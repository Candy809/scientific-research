package com.psy.test.dao;

import com.psy.test.model.Student;

public interface StudentDao extends BaseDao<Student> {
    Student login(Student student);
}
