package com.example.springboottest.core;

import com.example.springboottest.bean.model.UserInfo;
import com.example.springboottest.core.session.SessionFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lizy
 * @Description: 自定义拦截器，拦截用户是否登录
 * @Date： Created in 13:32 2017/11/18
 * @Modificd BY:
 * @Description:
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //获取session
        UserInfo userInfo = SessionFactory.getSessionUser(request);

        if (userInfo == null) {
            response.sendRedirect(request.getContextPath() + "/admin");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
