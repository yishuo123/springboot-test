package com.example.springboottest.core.config;

import com.example.springboottest.core.Const;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @author: lizy
 * @Description: Security config类配置用户登录
 * @Date： Created in 10:55 2017-12-01
 * @Modificd BY:
 * @Description:
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());

        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/login/**");

        // 拦截配置
        addInterceptor.addPathPatterns("/**");
    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                throws Exception {
            HttpSession session = request.getSession();
            if (session.getAttribute(Const.SESSION_USERINFO) != null) {

                return true;
            }

            //获取http路径
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";


            // 跳转登录
            //response.sendRedirect("/?login");
            sendRedirect(response, basePath);
            return false;
        }
    }

    /**
     * 通过设置html，方式iframe不能正确跳转
     *
     * @param response
     * @param basePath
     * @throws Exception
     */
    private void sendRedirect(HttpServletResponse response,
                              String basePath) throws Exception {

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
//        out.println("window.open ('"+ basePath +"login','_top')");
        out.println("window.top.location='" + basePath + "login'");
        out.println("</script>");
        out.println("</html>");
    }
}
