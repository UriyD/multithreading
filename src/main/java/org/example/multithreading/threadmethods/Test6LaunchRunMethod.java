package org.example.multithreading.threadmethods;

public class Test6LaunchRunMethod implements Runnable {

    @Override
    public void run() {
        System.out.println("Method run. Thread name = " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Test6LaunchRunMethod());
        thread.run();
        System.out.println("Method main. Thread name = " + Thread.currentThread().getName());
    }
}
