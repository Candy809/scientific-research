package com.psy.test.service.impl;



import com.psy.test.dao.MarkDao;
import com.psy.test.model.Mark;
import com.psy.test.service.MarkService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MarkServiceImpl implements MarkService {
    private MarkDao markDao;

    public void setMarkDao(MarkDao markDao) {
        this.markDao = markDao;
    }

    @Override
    public List<Mark> findAll() {
        return markDao.findAll();
    }

    @Override
    public Mark findById(String mark_id) {
        return markDao.findById(mark_id);
    }

    @Override
    public void update(Mark mark) {
        markDao.update(mark);
    }
}
