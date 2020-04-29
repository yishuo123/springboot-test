package com.example.springboottest.service.impl;

import com.example.springboottest.anno.WebServiceLogger;
import com.example.springboottest.dao.UserMapper;
import com.example.springboottest.model.User;
import com.example.springboottest.service.UserService;
import com.example.springboottest.util.Page;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @WebServiceLogger(logger = "查询用书全部数据！！！")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    //  分页查询
    @Override
    public Page<Map<String, Object>> selectAll(Map<String, Object> map) throws Exception {
        List<Map<String, Object>> list = userMapper.selectAll(map);
        Integer total = userMapper.selectCount(map);
        return new Page<Map<String, Object>>(total,list);
    }


    /**
     * 在service 里面调用另一个事物的方法 需要开启aop事务
     * 在springboot启动类上 加上 @EnableAspectJAutoProxy 注解
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> getListUser() {
        String  name = "李斯特";
        this.findByName(name);

        // 调用 别的事务上的方法，
          User user = ((UserService) AopContext.currentProxy()).findByName(name);

        return null;
    }


}
