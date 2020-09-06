package com.example.springboottest.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 的配置类
 */

@Configuration
public class shiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //设置安全管理器

        /**
         * 添加Shiro 内置的的过滤器
         *      常用的过滤器有
         *          anon ： 无需认证就可以访问
         *          authc : 必须认证才可以访问
         *          user ： 如果使用 rememberMe 的功能可以直接访问
         *          perms : 该资源必须得到资源的权限才可以访问
         *          role ： 该资源必须得到角色的权限才可以访问
         */

        Map<String, String> map = new LinkedHashMap<>();
//        map.put("/user/insert","authc");
//        map.put("/user/update","authc");

        // 或者是

//        map.put("/user/login","anon");
//        map.put("/user/tologin","anon");

        // 不进行拦截
//        map.put("/list","anon");
//
//        map.put("/*","authc");


        // 配置shiro 的过滤器
        // 拦截未授权的请求
//        map.put("/user/insert","perms[user:insert]");
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        //修改要拦截的登陆页面
//        shiroFilterFactoryBean.setLoginUrl("/user/tologin");

        //设置未授权跳转的页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/user/noAuthc");

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    /**
     * 创建realm
     */
    @Bean(name = "userRealm")
    public UserRealm gerRealm() {
        return new UserRealm();
    }


}
