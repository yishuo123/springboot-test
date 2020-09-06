package com.example.springboottest.core;

/**
 * 常量配置
 *
 * @author lizy
 * 2016年11月27日
 */
public class Const {

    public static final String SESSION_USERINFO = "userInfo";    //用户SESSION信息

    public static final String COOKIE_MENUID = "MENUID";        // Cookie MENUID

    public static final int RECEIPT_INCR_1 = 1;                    //单据编号自增值 1 初始化，自增

    /**
     * REDIS KEY
     */
    public static final String REDIS_RECEIPT_INCR = "scan:receipt:incr";    //单据编号自增值


}
