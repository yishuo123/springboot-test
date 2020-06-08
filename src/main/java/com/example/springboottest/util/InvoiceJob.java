package com.example.springboottest.util;

import com.example.springboottest.core.Const;
import com.example.springboottest.core.util.DateUtil;
import com.example.springboottest.core.util.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author lizy
 * @Date 2018/7/25 20:47
 * @Version V1.0
 * @Description: 定时任务
 */
@Component
@EnableScheduling
public class InvoiceJob {
    private Logger logger = Logger.getLogger(InvoiceJob.class);

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 每天凌晨单据编号流水号初始化为1
     */
    @Scheduled(cron = "0 0 0 * * ?")        //每天凌晨执行一次
    //@Scheduled(cron="0/30 * *  * * ? ")   //每30秒执行一次
    public void initReceiptIncr(){
        try {
            logger.info("初始化单据流水编号 time:"+ DateUtil.sdfDateTime2(new Date()));
            redisUtil.set(Const.REDIS_RECEIPT_INCR, Const.RECEIPT_INCR_1 + "");

        }catch (Exception e){
            logger.error("每天凌晨单据编号流水号初始化异常", e);
        }
    }
}
