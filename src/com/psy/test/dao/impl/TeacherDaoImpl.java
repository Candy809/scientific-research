package com.psy.test.dao.impl;


import com.psy.test.dao.TeacherDao;
import com.psy.test.model.Teacher;

import java.util.List;

public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao {
    @Override
    public Teacher login(Teacher teacher) {
        List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find("from Teacher where tea_username=? and tea_password=?", teacher.getTea_username(),teacher.getTea_password());
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
