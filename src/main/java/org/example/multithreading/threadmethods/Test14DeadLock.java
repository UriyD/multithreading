package org.example.multithreading.threadmethods;

public class Test14DeadLock {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }

}

class Thread10 extends Thread {
    public void run() {
        System.out.println("Thread10: Attempt to capture screen object lock 1");
        synchronized (Test14DeadLock.lock1) {
            System.out.println("Thread10: Screen object lock1 captured");
            System.out.println("Thread10: Attempt to capture screen object lock 2");
            synchronized (Test14DeadLock.lock2) {
                System.out.println("Thread10: Screen object lock1 and lock2 captured");
            }
        }
    }
}

class Thread20 extends Thread {
    public void run() {
        System.out.println("Thread20: Attempt to capture screen object lock2");
        synchronized (Test14DeadLock.lock1) {
            System.out.println("Thread20: Screen object lock2 captured");
            System.out.println("Thread20: Attempt to capture screen object lock1");
            synchronized (Test14DeadLock.lock2) {
                System.out.println("Thread20: Screen object lock1 and lock2 captured");
            }
        }
    }
}