package com.psy.test.service.impl;


import com.psy.test.dao.ZhuanLiDao;
import com.psy.test.model.PageBean;
import com.psy.test.model.ZhuanLi;
import com.psy.test.service.ZhuanLiService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class ZhuanLiServiceImpl implements ZhuanLiService {
    private ZhuanLiDao zhuanLiDao;

    public void setZhuanLiDao(ZhuanLiDao zhuanLiDao) {
        this.zhuanLiDao = zhuanLiDao;
    }

    @Override
    public PageBean<ZhuanLi> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<ZhuanLi> pageBean = new PageBean<ZhuanLi>();
        //设置当前页数
        pageBean.setCurrPage(currPage);
        //设置每页显示记录数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        Integer totalCount = zhuanLiDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        double tc = totalCount;
        Double ceil = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(ceil.intValue());
        //每页显示数据的集合asd
        Integer begin = (currPage - 1) * pageSize;
        List<ZhuanLi> list = zhuanLiDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);
        System.out.println(begin + "---" + pageSize);
        return pageBean;
    }

    @Override
    public void save(ZhuanLi zhuanli) {
        zhuanLiDao.save(zhuanli);
    }

    @Override
    public ZhuanLi findById(Long zl_id) {
        return zhuanLiDao.findById(zl_id);
    }

    @Override
    public void delete(ZhuanLi zhuanli) {
        zhuanLiDao.delete(zhuanli);
    }

    @Override
    public void update(ZhuanLi zhuanli) {
        zhuanLiDao.update(zhuanli);
    }

    @Override
    public List<ZhuanLi> findAll() {
        return zhuanLiDao.findAll();
    }
}
