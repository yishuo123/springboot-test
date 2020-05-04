package com.example.springboottest.asynctackconfig;


import com.example.springboottest.Asyncthread.AsyncTaskConfig;
import com.example.springboottest.Asyncthread.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.example.springboottest.*"})

public class AsyncTackConfigTest {

    @Autowired
    AsyncTaskService asyncTaskService;


    @Test
    public void test(){
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncTaskConfig.class);
////        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
////        for(int i = 0; i < 10; i++) {
////            asyncTaskService.executeAsyncTask(i);
////        }

        for(int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
        }
    }
}
