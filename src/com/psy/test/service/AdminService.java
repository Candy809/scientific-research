package com.psy.test.service;

import com.psy.test.model.Admin;
import com.psy.test.model.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface AdminService {
    Admin login(Admin admin);

    void save(Admin admin);

    PageBean<Admin> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    Admin findById(Long admin_id);

    void update(Admin admin);

    void delete(Admin admin);

    List<Admin> findAll();
}
