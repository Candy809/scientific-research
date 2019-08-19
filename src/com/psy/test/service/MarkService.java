package com.psy.test.service;


import com.psy.test.model.Mark;

import java.util.List;

public interface MarkService {
    List<Mark> findAll();

    Mark findById(String mark_id);

    void update(Mark mark);
}
