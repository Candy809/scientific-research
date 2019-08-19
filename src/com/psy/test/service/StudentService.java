package com.psy.test.service;


import com.psy.test.model.PageBean;
import com.psy.test.model.Student;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface StudentService {

    void save(Student student);

    PageBean<Student> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    Student findById(Long stu_id);

    void update(Student student);

    void delete(Student student);

    Student login(Student student);

    List<Student> findAll();
}
