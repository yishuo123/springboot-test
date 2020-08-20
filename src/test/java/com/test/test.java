package com.test;

import org.apache.poi.ss.formula.functions.T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class test {

    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    public static void main(String[] args) throws IOException {

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","iear",
                "pple", "orange", maximum( "iear", "pple", "orange" ) );



//        double random = Math.random();
//        System.out.println(random*100);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");

        String s[][] = new String[3][];
        s[0] = new String[2];
        s[1] = new String[3];
        s[0][0] = new String("Good");
        s[0][1] = new String("Luck");
        s[1][0] = new String("to");
        s[1][1] = new String("you");
        s[1][2] = new String("!");

        System.out.println("--------------");
        // 初始化 Date 对象
        Date date = new Date();

        //c的使用
//        System.out.printf("全部日期和时间信息：%tc%n",date);
//        //f的使用
//        System.out.printf("年-月-日格式：%tF%n",date);
//        //d的使用
//        System.out.printf("月/日/年格式：%tD%n",date);
//        //r的使用
//        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
//        //t的使用
//        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
//        //R的使用
//        System.out.printf("HH:MM格式（24时制）：%tR%n",date);

        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
//            c = (char) br.read();
            str =  br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }


}
