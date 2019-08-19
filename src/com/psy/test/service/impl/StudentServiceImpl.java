package com.psy.test.service.impl;


import com.psy.test.dao.StudentDao;
import com.psy.test.model.PageBean;
import com.psy.test.model.Student;
import com.psy.test.service.StudentService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    //保存学生方法
    public void save(Student student) {
        studentDao.save(student);
    }


    @Override
    //分页查询方法
    public PageBean<Student> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<Student> pageBean = new PageBean<Student>();
        //设置当前页数
        pageBean.setCurrPage(currPage);
        //设置每页显示记录数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        Integer totalCount = studentDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        double tc = totalCount;
        Double ceil = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(ceil.intValue());
        //每页显示数据的集合asd
        Integer begin = (currPage - 1) * pageSize;
        List<Student> list = studentDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public Student findById(Long stu_id) {
        return studentDao.findById(stu_id);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(Student student) {
        studentDao.delete(student);
    }

    @Override
    public Student login(Student student) {
        return studentDao.login(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
