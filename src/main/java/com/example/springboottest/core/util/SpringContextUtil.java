package com.example.springboottest.core.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/***
 * spring 上下文环境工具类
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        return appContext;
    }

    public static Object getBean(String name)
            throws BeansException {
        return appContext.getBean(name);
    }

    public static Object getBean(String name, Class requiredType)
            throws BeansException {
        return appContext.getBean(name, requiredType);
    }

    public static boolean containsBean(String name) {
        return appContext.containsBean(name);
    }

    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return appContext.isSingleton(name);
    }

    public static Class getType(String name) throws NoSuchBeanDefinitionException {
        return appContext.getType(name);
    }


    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return appContext.getAliases(name);
    }
}
