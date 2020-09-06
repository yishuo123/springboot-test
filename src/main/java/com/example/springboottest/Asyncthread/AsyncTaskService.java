package com.example.springboottest.Asyncthread;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTaskService {

    @Async //开启异步请求
    public void executeAsyncTask(int i) {
        System.out.println("执行异步任务:>>>>>>>>>" + i);
    }
}
