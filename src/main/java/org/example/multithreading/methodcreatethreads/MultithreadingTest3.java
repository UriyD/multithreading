package org.example.multithreading.methodcreatethreads;
//Example with extend Thread
//public class MultithreadingTest3 extends Thread {
//    public void run() {
//        for (int i = 1; i <= 1000; i++) {
//            System.out.println(i);
//        }
//    }
//    public static void main(String[] args) {
//        MultithreadingTest3 multithreadingTest3 = new MultithreadingTest3();
//        multithreadingTest3.start();
//
//        for (int i = 1000; i > 0; i--) {
//            System.out.println(i);
//        }
//    }
//}

//Example with implements Runnable
public class MultithreadingTest3 implements Runnable {
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
       Thread thread = new Thread(new MultithreadingTest3());
       thread.start();

        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}