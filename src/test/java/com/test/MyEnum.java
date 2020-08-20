package com.test;

public enum MyEnum {

     MONDAY("星期一"),
     TUESDAY("星期二");
     private String desc;//中文描述

     // 自定义构造函数
     private MyEnum(String desc) {
          this.desc = desc;
     }

     @Override
     public String toString() {
          return "MyEnum{" +
                  "desc='" + desc + '\'' +
                  '}';
     }

     public static void main(String[] args){
          for (MyEnum day:MyEnum.values()) {
               System.out.println("name:"+day.name()+
                       ",desc:"+day.toString());
          }
     }
}
