package com.test;

public class MyRun implements Runnable {

    private volatile  boolean active;
    @Override
    public void run() {
        this.active = true;
        while (active){
            System.out.println("active ="+active );
        }
    }
    public  void stop(){

        this.active = false;
        System.out.println("stop");
    }

    public static void main(String[] args) throws InterruptedException {
        MyRun  myRun = new MyRun();
        myRun.run();
//         myRun.stop();
    }
}
