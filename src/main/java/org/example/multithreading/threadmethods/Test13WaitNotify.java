package org.example.multithreading.threadmethods;

public class Test13WaitNotify {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}

class Market {
//    private final Object lock = new Object();
    private int breadCount = 0;

    public synchronized void getBread() {
            while (breadCount < 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            breadCount--;
            System.out.println("Consumer buy 1 bread");
            System.out.println("Amount of bread in marker = " + breadCount);
            notify();
    }

//    public void getBread() {
//        synchronized (lock) {
//            while (breadCount < 1) {
//                try {
//                  lock.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            breadCount--;
//            System.out.println("Consumer buy 1 bread");
//            System.out.println("Amount of bread in marker = " + breadCount);
//            lock.notify();
//        }
//    }

    public synchronized   void putBread() {
            while (breadCount >= 5) {
                try {
                   wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            breadCount++;
            System.out.println("Producer added 1 bread");
            System.out.println("Amount of bread in market = " + breadCount);
            notify();

    }
//    public    void putBread() {
//        synchronized (lock) {
//            while (breadCount >= 5) {
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            breadCount++;
//            System.out.println("Producer added 1 bread");
//            System.out.println("Amount of bread in market = " + breadCount);
//            lock.notify();
//        }
//    }
}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}

