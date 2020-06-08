package com.example.springboottest.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: lizy
 * @Description:
 * @Date： Created in 13:38 2017/11/17
 * @Modificd BY:
 * @Description:
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("")
    public String index(HttpServletRequest request){
        return "redirect:/admin";
    }
}
