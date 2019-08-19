package com.psy.test.service;


import com.psy.test.model.PageBean;
import com.psy.test.model.XueShu;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface XueShuService {
    PageBean<XueShu> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    void save(XueShu xueshu);

    XueShu findById(Long xs_id);

    void delete(XueShu xueshu);

    void update(XueShu xueshu);

    List<XueShu> findAll();
}
