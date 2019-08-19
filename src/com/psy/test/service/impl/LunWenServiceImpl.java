package com.psy.test.service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.psy.test.dao.LunWenDao;
import com.psy.test.model.LunWen;
import com.psy.test.model.PageBean;
import com.psy.test.service.LunWenService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class LunWenServiceImpl implements LunWenService {
    private LunWenDao lunWenDao;

    public void setLunWenDao(LunWenDao lunWenDao) {
        this.lunWenDao = lunWenDao;
    }

    @Override
    public PageBean<LunWen> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
        PageBean<LunWen> pageBean = new PageBean<LunWen>();
        //设置当前页数
        pageBean.setCurrPage(currPage);
        //设置每页显示记录数
        pageBean.setPageSize(pageSize);
        //设置总记录数
        Integer totalCount = lunWenDao.findCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        double tc = totalCount;
        Double ceil = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(ceil.intValue());
        //每页显示数据的集合asd
        Integer begin = (currPage - 1) * pageSize;
        List<LunWen> lw_list = lunWenDao.findByPage(detachedCriteria,begin,pageSize);
        pageBean.setList(lw_list);
        System.out.println(begin+"---"+pageSize);
        return pageBean;
    }

    @Override
    public void save(LunWen lunwen) {
        lunWenDao.save(lunwen);
    }

    @Override
    public LunWen findById(Long lw_id) {
        return lunWenDao.findById(lw_id);
    }

    @Override
    public void delete(LunWen lunwen) {
        lunWenDao.delete(lunwen);
    }

    @Override
    public void update(LunWen lunwen) {
        lunWenDao.update(lunwen);
    }

    @Override
    public List<LunWen> findAll() {
        return lunWenDao.findAll();
    }

    @Override
    public List<LunWen> findBystu_lunwen_id(Long stu_lunwen_id) {
        return lunWenDao.findBystu_lunwen_id(stu_lunwen_id);
    }


}
