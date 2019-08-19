package com.psy.test.service;


import com.psy.test.model.PageBean;
import com.psy.test.model.Student;
import com.psy.test.model.Teacher;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface TeacherService {

    void save(Teacher teacher);

    PageBean<Teacher> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    Teacher findById(Long tea_id);

    void update(Teacher teacher);

    void delete(Teacher teacher);

    Teacher login(Teacher teacher);

    List<Teacher> findAll();
}
