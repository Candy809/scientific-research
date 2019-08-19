package com.psy.test.dao.impl;


import com.psy.test.dao.AdminDao;
import com.psy.test.model.Admin;

import java.util.List;

public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {
    @Override
    //DAO中根据用户名和密码进行查询的方法
    public Admin login(Admin admin) {
        List<Admin> list = (List<Admin>) this.getHibernateTemplate().find("from Admin where admin_username=? and admin_password=?", admin.getAdmin_username(), admin.getAdmin_password());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
