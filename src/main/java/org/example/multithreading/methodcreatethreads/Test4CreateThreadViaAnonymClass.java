package org.example.multithreading.methodcreatethreads;

public class Test4CreateThreadViaAnonymClass {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Privet");
            }
        }).start();

        new Thread(() -> System.out.println("Privet")).start();
    }
}
