package com.psy.test.service;


import com.psy.test.model.PageBean;
import com.psy.test.model.ZhuanLi;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface ZhuanLiService {
    PageBean<ZhuanLi> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    void save(ZhuanLi zhuanli);

    ZhuanLi findById(Long zl_id);

    void delete(ZhuanLi zhuanli);

    void update(ZhuanLi zhuanli);

    List<ZhuanLi> findAll();
}
