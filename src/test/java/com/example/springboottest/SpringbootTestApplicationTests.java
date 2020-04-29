package com.example.springboottest;

import com.example.springboottest.anno.WebLogger;
import com.example.springboottest.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTestApplicationTests {

    @Test
   public void contextLoads() {

            List<User> list = new ArrayList<>();
            User student0=new User(1,"kobe","kobe","123","user-add");
            User student1=new User(2,"james","james","123","user-add");
            User student2=new User(3,"rose","rose","123","user-add");

            list.add(student0);
            list.add(student1);
            list.add(student2);

//            return list;

    }

//    public static void main(String[] args) {
//
//        int[] datas = {5,2,3,2,4,5,1,2,1,5,1};
//        int[] nums = new int[10];//0-9,此处若数组中的最大值为 123，则数组长度应为 >= 124
//
//        System.out.println(datas.length);
//
//        System.out.println("------------");
//        for (int i = 0; i < datas.length; i++) {
//            System.out.println(i+":"+datas[i]);
//            int n = datas[i] - 0;
//            nums[n]++;
//            System.out.println("nums : "+nums[n]);
//        }
//        System.out.println("======================");
//        int maxTime = 0;
//        for (int i = 0; i < nums.length; i++) {
//
//            System.out.println(i+":"+nums[i]);
//            if(nums[i] > maxTime){
//                maxTime = nums[i];
//            }
//        }
//
//        System.out.println("最多的出现"+maxTime+"次");
//
//        int num = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(maxTime == nums[i]){
//                num = i;
//            }
//        }
//
//        System.out.println("出现次数最多："+maxTime+"次;且最大的数是："+num);
//
//    }

}

