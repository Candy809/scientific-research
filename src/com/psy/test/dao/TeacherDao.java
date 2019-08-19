package com.psy.test.dao;



import com.psy.test.model.Teacher;
public interface TeacherDao extends BaseDao<Teacher> {
    Teacher login(Teacher teacher);
}
