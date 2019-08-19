package com.psy.test.service;


import com.psy.test.model.KeYan;
import com.psy.test.model.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface KeYanService {
    PageBean<KeYan> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

    void save(KeYan keyan);

    KeYan findById(Long ky_id);

    void delete(KeYan keyan);

    void update(KeYan keyan);

    List<KeYan> findAll();
}
