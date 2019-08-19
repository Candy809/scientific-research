package com.psy.test.service.impl;



import com.psy.test.dao.EchartDao;
import com.psy.test.service.EchartService;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class EchartServiceImpl implements EchartService {
    private EchartDao echartDao;

    public void setEchartDao(EchartDao echartDao) {
        this.echartDao = echartDao;
    }
}
