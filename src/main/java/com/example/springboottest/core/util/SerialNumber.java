package com.example.springboottest.core.util;

import com.example.springboottest.core.Const;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author lizy
 * @Date 2018/7/26 10:03
 * @Version V1.0
 * @Description: 流水号
 */
public class SerialNumber {

    @Autowired
    static RedisUtil redisUtil;

    /**
     * 4位随机数
     * 生成流水号
     *
     * @return
     */
    public static String getNum() {

        int x = (int) ((Math.random() * 9 + 1) * 1000);

        return x + "";
    }

    /**
     * 有年月日生成时间 + 4位流水号
     *
     * @return
     */
    public static String getReceiptNumber() {

        String no = String.format("%04d", getRedisValue());

        //单据编号规则：公司名称首字母4个字母 + 年月日6位 + “4位流水号”
        return "JHRZ" + DateUtil.formatDate(new Date(), "yyMMdd") + no;
    }

    //主方法测试
    public static void main(String[] args) {
        String m = getNum();
        System.out.println(m);

    }

    /**
     * 从redis中获取当天四位流水号
     *
     * @return
     */
    public static Long getRedisValue() {
        if (redisUtil == null) {
            redisUtil = (RedisUtil) SpringContextUtil.getBean("redisUtil");
        }

        Long num = redisUtil.incr(Const.REDIS_RECEIPT_INCR, Const.RECEIPT_INCR_1);

        return num;
    }


}