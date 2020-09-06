package com.example.springboottest.set;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testSet {


    // 无序的  不能重复
    @Test
    public void testSet() {
        Set set = new HashSet();
//        set.add("1");
//        set.add("1");
//        set.add("2");
//        set.add("3");
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(4);
        set.add("");
        set.add("");


        System.out.println("set 的大小" + set.size());
        System.out.println("set 的值 " + set.toString());

        // treeSet
        Set treeSet = new TreeSet();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(4);

        System.out.println(" treeSet 的大小" + treeSet.size());
        System.out.println(" treeSet 的值" + treeSet.toString());


    }


    // 有序的   能重复
    @Test
    public void testList() {
        List list = new ArrayList();

        list.add("1");
        list.add("1");
        list.add("2");
        list.add("4");
        list.add("");
        list.add("");

        System.out.println("list的大小 " + list.size());
        System.out.println("list的值 " + list.toString());

        Vector vector = new Vector();
        vector.add(1);
        vector.add(1);
        vector.add(2);
        System.out.println("vector 的大小" + vector.size());
        System.out.println("vector 的值" + vector.toString());


        List list1 = new LinkedList();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(2);
        list1.add(1, 9);
        System.out.println("LinkedList 的大小" + list1.size());
        System.out.println("LinkedList 的值" + list1.toString());


    }


    /**
     * map 是对应的key 和value
     * <p>
     * 在HashMap 中key 不能重复。 只能有一个   value 可义重复 。 可以存在多个,
     * <p>
     * <p>
     * hashTable ke 和value 都不能为null   是线程安全的
     * <p>
     * LinkedHashMap保证数据可以保持插入顺序 是在hashmap的基础上多的一个插入的顺序
     * <p>
     * treeMap  是按数据结构是红黑树 ，  是按key 的大小来排序的
     */
    @Test
    public void testMap() {
        Map map = new HashMap();
        map.put("a", "1");
        map.put("a", "3");
        map.put("b", "2");
        map.put("c", "2");
        map.put(null, "5");

        System.out.println("HashMap 的大小 ： " + map.size());
        System.out.println("HashMap 的值 ： " + map.toString()); //HashMap 的值 ： {a=3, b=2, c=2}


        //
        Map map1 = new Hashtable();
        map1.put("a", "1");
        map1.put("a", "3");
        map1.put("b", "2");
        map1.put("c", "2");
//        map1.put("",null);


        System.out.println("hashtable 的值" + map1.toString()); // hashtable 的值{b=2, a=3, c=2}


        Map map2 = new LinkedHashMap();
        map2.put("a", 5);
        map2.put("c", 4);
        map2.put("a", 1);
        map2.put("b", 2);

        System.out.println("LinkedHashMap 的值：" + map2.toString());

    }
}
