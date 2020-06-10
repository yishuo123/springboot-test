package com.example.springboottest.set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class hashMapTest {

    @Test
    public void hashMapTest1(){

        Map map = new LinkedHashMap();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");


        // 直接获取hashMap的entry   获取map中数组下标对应的entry 对象是个键值对  能获取key 和value
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(">>>>>key:="+key+">>>>>>value:="+value);
        }
    }

    @Test
    public void hashMapiterator(){
        Map map = new HashMap();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            // 获取map的key
            Object key = iterator.next();
            // 根据key 获取value
            Object value = map.get(key);

            System.out.println(">>>>>key:="+key+">>>>>>>:="+value);

        }
    }
}
