package com.example.springboottest.singleton;

public class SingletonObject {

    /**
     * 单例模式   懒汉
     */

    private static SingletonObject singletonObject = null;

    public static  SingletonObject getInstance(){
        if(singletonObject == null){
            synchronized (SingletonObject.class){
                if(singletonObject == null){
                    singletonObject =  new SingletonObject();
                }
            }
        }
        return singletonObject;
    }


    public static void main(String[] args) {
        SingletonObject.getInstance();
    }

}
