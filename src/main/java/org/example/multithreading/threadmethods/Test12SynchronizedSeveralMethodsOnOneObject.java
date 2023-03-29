package org.example.multithreading.threadmethods;

public class Test12SynchronizedSeveralMethodsOnOneObject {
    static final Object lock = new Object();
     void mobileCall() {
         synchronized (lock) {
             System.out.println("Mobile call starts");
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("Mobile call ends");
         }
    }

     void skypeCall() {
         synchronized (lock) {
             System.out.println("Skype call starts");
             try {
                 Thread.sleep(5000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("Skype call ends");
         }
     }

     void whatsappCall() {
         synchronized (lock) {
             System.out.println("WhatsappCall call starts");
             try {
                 Thread.sleep(7000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("WhatsappCall call ends");
         }
     }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MobileCall());
        Thread thread2 = new Thread(new SkypeCall());
        Thread thread3 = new Thread(new WhatsappCall());
        thread1.start();
        thread2.start();
        thread3.start();
    }


}

class MobileCall implements Runnable {
    @Override
    public void run() {
        new Test12SynchronizedSeveralMethodsOnOneObject().mobileCall();
    }
}

class SkypeCall implements Runnable {
    @Override
    public void run() {
        new Test12SynchronizedSeveralMethodsOnOneObject().skypeCall();
    }
}

class WhatsappCall implements Runnable {
    @Override
    public void run() {
        new Test12SynchronizedSeveralMethodsOnOneObject().whatsappCall();
    }
}


