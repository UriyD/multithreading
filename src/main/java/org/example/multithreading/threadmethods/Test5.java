package org.example.multithreading.threadmethods;

public class Test5 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        myThread5.setName("my potok");
        myThread5.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name of my thread5 = " + myThread5.getName() + " Priority of mytrhread5 = " + myThread5.getPriority());



    }
}

class MyThread5 extends Thread {
    public void run() {
        System.out.println("privet");
    }
}
