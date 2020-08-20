package com.test;

public class TestLength {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        doIt(myArray);
        for (int i = 0; i < myArray.length; i++)
        {
            System.out.print(myArray[i] + " ");
        }


        Integer i = new Integer(10);
        Integer j = new Integer(20);
        swap(i, j);
        System.out.println("i = " + i + ", j = " + j);
    }


        static void doIt( int[] z )
        {
            int temp = z[z.length-1];
            z[z.length-1] = z[0];
            z[0] = temp;
        }



    public static void swap(Integer i, Integer j) {
        Integer temp = new Integer(i);
        i = j;
        j = temp;
    }


}
