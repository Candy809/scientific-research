package com.psy.test.service;


import com.psy.test.model.LunWen;
import com.psy.test.model.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LunWenService {
    PageBean<LunWen> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    void save(LunWen lunwen);

    LunWen findById(Long lw_id);

    void delete(LunWen lunwen);

    void update(LunWen lunwen);

    List<LunWen> findAll();

    List<LunWen> findBystu_lunwen_id(Long stu_lunwen_id);
}
