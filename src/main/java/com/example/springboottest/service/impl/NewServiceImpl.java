package com.example.springboottest.service.impl;

import com.example.springboottest.dao.NewMapper;
import com.example.springboottest.model.taskRule;
import com.example.springboottest.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceImpl implements NewService {


    @Autowired
    private NewMapper newMapper;

    @Override
    public List<taskRule> findAll() throws Exception {
        List<taskRule> taskRuleList = newMapper.findAll();
        return taskRuleList;
    }
}
