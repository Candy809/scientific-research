package com.psy.test.service.impl;


import com.psy.test.dao.KeYanDao;
import com.psy.test.model.KeYan;
import com.psy.test.model.PageBean;
import com.psy.test.service.KeYanService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class KeYanServiceImpl implements KeYanService {
    private KeYanDao keYanDao;

    public void setKeYanDao(KeYanDao keYanDao) {
        this.keYanDao = keYanDao;
    }

    @Override
    public PageBean<KeYan> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<KeYan> pageBean = new PageBean<KeYan>();
        //设置当前页数
        pageBean.setCurrPage(currPage);
        //设置每页显示记录数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        Integer totalCount = keYanDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        double tc = totalCount;
        Double ceil = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(ceil.intValue());
        //每页显示数据的集合asd
        Integer begin = (currPage - 1) * pageSize;
        List<KeYan> list = keYanDao.findByPage(detachedCriteria, begin, pageSize);
        pageBean.setList(list);
        System.out.println(begin + "---" + pageSize);
        return pageBean;
    }

    @Override
    public void save(KeYan keyan) {
        keYanDao.save(keyan);
    }

    @Override
    public KeYan findById(Long ky_id) {
        return keYanDao.findById(ky_id);
    }

    @Override
    public void delete(KeYan keyan) {
        keYanDao.delete(keyan);
    }

    @Override
    public void update(KeYan keyan) {
        keYanDao.update(keyan);
    }

    @Override
    public List<KeYan> findAll() {
        return keYanDao.findAll();
    }
}
