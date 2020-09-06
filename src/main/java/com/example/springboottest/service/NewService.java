package com.example.springboottest.service;

import com.example.springboottest.model.taskRule;

import java.util.List;

public interface NewService {

    List<taskRule> findAll() throws Exception;
}
