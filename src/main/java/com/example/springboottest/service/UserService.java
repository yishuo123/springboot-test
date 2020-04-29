package com.example.springboottest.service;

import com.example.springboottest.model.User;
import com.example.springboottest.util.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> findAll();

    User findByName(String name);

    User getById(int id);


    Page<Map<String,Object>> selectAll(Map<String,Object> map)throws Exception;

    List<User> getListUser();

    //导入
    Integer importExcel(MultipartFile myFile)throws Exception;

    // 导出
    void exportExcel(HttpServletResponse response)throws Exception;
}
