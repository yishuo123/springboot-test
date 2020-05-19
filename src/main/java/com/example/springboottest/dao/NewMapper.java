package com.example.springboottest.dao;

import com.example.springboottest.model.taskRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewMapper {

    List<taskRule> findAll()throws Exception;
}
