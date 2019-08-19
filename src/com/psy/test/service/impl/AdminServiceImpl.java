package com.psy.test.service.impl;


import com.psy.test.dao.AdminDao;
import com.psy.test.model.Admin;
import com.psy.test.model.PageBean;
import com.psy.test.service.AdminService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class AdminServiceImpl implements AdminService {
    //注入管理员的DAO
    private AdminDao adminDao;
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    //管理员登录方法
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    //保存管理员的方法
    public void save(Admin admin) {
        adminDao.save(admin);
    }

    @Override
    //管理员分页查询的方法
    public PageBean<Admin> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<Admin> pageBean = new PageBean<Admin>();
        //设置当前页数
        pageBean.setCurrPage(currPage);
        //设置每页显示记录数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        Integer totalCount = adminDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        double tc = totalCount;
        Double ceil = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(ceil.intValue());
        //每页显示数据的集合
        Integer begin = (currPage - 1) * pageSize;
        List<Admin> list = adminDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        System.out.println(begin+"---"+pageSize);
        return pageBean;
    }

    @Override
    //根据id查询的方法
    public Admin findById(Long admin_id) {
        return adminDao.findById(admin_id);
    }

    @Override
    //管理员修改的方法
    public void update(Admin admin) {
        adminDao.update(admin);
    }

    @Override
    //管理员删除方法
    public void delete(Admin admin) {
        adminDao.delete(admin);
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }
}
