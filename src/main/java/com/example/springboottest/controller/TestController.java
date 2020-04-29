package com.example.springboottest.controller;

import com.example.springboottest.anno.WebLogger;
import com.example.springboottest.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping("/list")
    @WebLogger("学生列表")
    @ResponseBody
    public List<User> list( String name){
        List<User> list = new ArrayList<>();
        User student0=new User(1,"kobe","kobe","123","user-add");
        User student1=new User(2,"james","james","123","user-add");
        User student2=new User(3,"rose","rose","123","user-add");

        list.add(student0);
        list.add(student1);
        list.add(student2);

        return list;
    }

}
