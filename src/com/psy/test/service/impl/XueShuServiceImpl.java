package com.psy.test.service.impl;


import com.psy.test.dao.XueShuDao;
import com.psy.test.model.PageBean;
import com.psy.test.model.XueShu;
import com.psy.test.service.XueShuService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class XueShuServiceImpl implements XueShuService {
    private XueShuDao xueShuDao;

    public void setXueShuDao(XueShuDao xueShuDao) {
        this.xueShuDao = xueShuDao;
    }

    @Override
    public PageBean<XueShu> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<XueShu> pageBean = new PageBean<XueShu>();
        //设置当前页数
        pageBean.setCurrPage(currPage);
        //设置每页显示记录数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        Integer totalCount = xueShuDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        double tc = totalCount;
        Double ceil = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(ceil.intValue());
        //每页显示数据的集合asd
        Integer begin = (currPage - 1) * pageSize;
        List<XueShu> list = xueShuDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);
        System.out.println(begin + "---" + pageSize);
        return pageBean;
    }

    @Override
    public void save(XueShu xueshu) {
        xueShuDao.save(xueshu);
    }

    @Override
    public XueShu findById(Long xs_id) {
        return xueShuDao.findById(xs_id);
    }

    @Override
    public void delete(XueShu xueshu) {
        xueShuDao.delete(xueshu);
    }

    @Override
    public void update(XueShu xueshu) {
        xueShuDao.update(xueshu);
    }

    @Override
    public List<XueShu> findAll() {
        return xueShuDao.findAll();
    }
}
