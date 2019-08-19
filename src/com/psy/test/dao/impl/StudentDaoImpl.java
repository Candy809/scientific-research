package com.psy.test.dao.impl;


import com.psy.test.dao.StudentDao;
import com.psy.test.model.Student;

import java.util.List;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

    @Override
    public Student login(Student student) {
        List<Student> list = (List<Student>) this.getHibernateTemplate().find("from Student where stu_username=? and stu_password=?", student.getStu_username(),student.getStu_password());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }


}
