package org.example.multithreading.threadmethods;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Test3Join {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begin");
        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join(4000);
        System.out.println(thread.getState());

        System.out.println("Method main ends");

    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Work Ends");

    }
}