package com.psy.test.dao;

import com.psy.test.model.Admin;

public interface AdminDao extends BaseDao<Admin> {
    Admin login(Admin admin);
}
