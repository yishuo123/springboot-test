package com.example.springboottest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {
    @Test
    public void test() {
        int x = 30;

        do {
            System.out.print("value of x : " + x);
            x++;
            System.out.print("\n");
        } while (x < 20);
    }

    @Test
    public void test1() {
        int a1 = 5;
        double a2 = (float) a1;
        System.out.println(a2);

    }
}
