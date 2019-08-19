package com.psy.test.dao;


import com.psy.test.model.LunWen;

import java.util.List;

public interface LunWenDao extends BaseDao<LunWen> {
    List<LunWen> findBystu_lunwen_id(Long stu_lunwen_id);
}
