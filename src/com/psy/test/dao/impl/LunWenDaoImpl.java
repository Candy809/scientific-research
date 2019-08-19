package com.psy.test.dao.impl;


import com.opensymphony.xwork2.ActionContext;
import com.psy.test.dao.LunWenDao;
import com.psy.test.model.LunWen;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;


public class LunWenDaoImpl extends BaseDaoImpl<LunWen> implements LunWenDao {
    @Override
    public List<LunWen> findBystu_lunwen_id(Long stu_lunwen_id) {
        System.out.println("dao获取到啦...");
        return (List<LunWen>) this.getHibernateTemplate().get(LunWen.class,stu_lunwen_id);
    }
}
