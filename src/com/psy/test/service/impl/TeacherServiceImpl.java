package com.psy.test.service.impl;



import com.psy.test.dao.TeacherDao;
import com.psy.test.model.PageBean;
import com.psy.test.model.Teacher;
import com.psy.test.service.TeacherService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class TeacherServiceImpl implements TeacherService {
private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    //保存老师的方法
    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }

    @Override
    //分页查询方法
    public PageBean<Teacher> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<Teacher> pageBean = new PageBean<Teacher>();
        //设置当前页数
        pageBean.setCurrPage(currPage);
        //设置每页显示记录数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        Integer totalCount = teacherDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        double tc = totalCount;
        Double ceil = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(ceil.intValue());
        //每页显示数据的集合asd
        Integer begin = (currPage - 1) * pageSize;
        List<Teacher> list = teacherDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        System.out.println(begin+"---"+pageSize);
        return pageBean;
    }

    @Override
    public Teacher findById(Long tea_id) {
        return teacherDao.findById(tea_id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    @Override
    public Teacher login(Teacher teacher) {
        return teacherDao.login(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }
}
