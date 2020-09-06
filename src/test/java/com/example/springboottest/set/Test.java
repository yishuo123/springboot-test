package com.example.springboottest.set;

import java.util.Arrays;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {

        Integer[] datas = {5, 1, 3, 3, 3, 3, 6, 6, 6, 6, 3};
        int[] nums = new int[10];//0-9,此处若数组中的最大值为 123，则数组长度应为 >= 124

        System.out.println(datas.length);

        System.out.println("------------");
        for (int i = 0; i < datas.length; i++) {
            System.out.println(i + ":" + datas[i]);
            int n = datas[i] - 0;
//            int n = datas[i];
            nums[n]++;
            System.out.println("新的数组是： " + nums);
//            System.out.println("nums : "+nums[n]);
        }
        System.out.println("======================");

        Integer[] integers = new Integer[nums.length];
        // 把int数组转成Integer数组
        for (int i = 0; i < nums.length; i++) {
            integers[i] = new Integer(nums[i]);
        }

        int min = (int) Collections.min(Arrays.asList(integers));
        int max = (int) Collections.max(Arrays.asList(integers));
        System.out.println("最小值为：" + min);
        System.out.println("最大值为：" + max);


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

//        System.out.println("出现次数最多："+maxTime+"次，该数是："+num);

    }


}
