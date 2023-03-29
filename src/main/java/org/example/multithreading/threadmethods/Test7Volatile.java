package org.example.multithreading.threadmethods;

public class Test7Volatile extends Thread {
    volatile boolean b = true;
    public void run() {
        long counter = 0;
        while(b){
            counter++;
        }
        System.out.println("Loopis finished. counter = " + counter );
    }


    public static void main(String[] args) throws InterruptedException {
        Test7Volatile thread = new Test7Volatile();
        thread.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds it is time to wake up!");
        thread.b = false;
        thread.join();
        System.out.println("End of program");



    }

}
