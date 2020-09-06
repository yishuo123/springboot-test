package com.example.springboottest.dao;

import com.example.springboottest.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> findAll();

    User findByName(String name);

    /**
     * 根据id来查用户信息
     *
     * @param id
     * @return
     */
    User getById(int id);


    List<Map<String, Object>> selectAll(Map<String, Object> map) throws Exception;

    Integer selectCount(Map<String, Object> map) throws Exception;
}
