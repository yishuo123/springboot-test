package com.example.springboottest.service;


import com.example.springboottest.core.ResultValue;

/**
 * @Author lizy
 * @Date 2018/7/25 20:43
 * @Version V1.0
 * @Description: 扫描机服务
 */
public interface ScanningService {

    /**
     * 启动扫描程序
     */
    ResultValue scanFlow();

}
