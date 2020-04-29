package com.example.springboottest.anno;

import com.google.gson.Gson;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.javassist.bytecode.SignatureAttribute;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 定义一个切面
 *
 */
@Aspect
@Component
public class WebLoggerAspect {
    // 定义一个切入点

    @Pointcut("@annotation(com.example.springboottest.anno.WebLogger)")
//    @Pointcut("@annotation(WebLogger)")
    public void getPoint(){}


    /**
     *
     * 增强处理 功能强大  类似于手刹 ， 用途： 可以决定执行目标的方法， 什么时候执行，
     * 具有 before after 和return 的功能  还是可以改变传入的参数和获取执行的返回值
     * 环绕是
     * @return
     */
//    @Around("getPoint()")
//    public Object around (JoinPoint joinPoint)throws Throwable {
//
//        long timeMillis = System.currentTimeMillis();
//        Object[] args = joinPoint.getArgs();
//        System.out.println("response 的内容:" +new Gson().toJson(args));
//        System.out.println("耗时: " + (System.currentTimeMillis() - timeMillis));
//
//        // 把获取的内容放回出去
//        return args;
//    }


    /**
     * 执行前
     */
    @Before("getPoint() && @annotation(WebLogger)")
    public void before(JoinPoint joinPoint){

        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        System.out.println("+++++++++++++++++++++++start+++++++++++++++++++++++");

        // 可以获取请求的路径 类型
        System.out.println("获取请求的路径： " + request.getRequestURI().toString());
        System.out.println("获取的类型： " + request.getMethod().toString());


        System.out.println("获取客户端的ip ：" + request.getRemoteAddr());

        // 可以获取请求的参数
        System.out.println("获取请求的参数" + new Gson().toJson(joinPoint.getArgs()));
        System.out.println("第二种方法获取请求的参数" + Arrays.toString(joinPoint.getArgs()));


        System.out.println("Description 获取的描述 ： " + getLogValue(joinPoint));

        //执行逻辑代码


    }

    private String getLogValue(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        WebLogger webLogger = method.getAnnotation(WebLogger.class);
        return webLogger.value();
    }


    @After("getPoint()")
    public void after(JoinPoint joinPoint){
        System.out.println("================================end================================");
    }

    /**
     * 设置service 层的日志信息
     * @param joinPoint
     * @param webServiceLogger
     */
    @After("execution(* com.example.springboottest.service.*.*(..)) && @annotation(webServiceLogger)")
    public void afterServiceLog(JoinPoint joinPoint, WebServiceLogger webServiceLogger){
        String logger = webServiceLogger.logger();
        System.out.println("》》》》》》》 后置通知开始执行》》 用户执行了【 "+logger+ "】操作");
    }



}
