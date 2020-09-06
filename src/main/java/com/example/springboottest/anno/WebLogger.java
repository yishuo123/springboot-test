package com.example.springboottest.anno;

import java.lang.annotation.*;

/**
 * 定义目标类  可以在类上或者是方法上
 * 生命周期     在运行时执行
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WebLogger {

    String value() default "";

    String userName() default "";

    String password() default "";


}
