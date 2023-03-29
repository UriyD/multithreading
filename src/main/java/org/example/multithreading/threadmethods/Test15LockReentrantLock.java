package org.example.multithreading.threadmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test15LockReentrantLock {
    public static void main(String[] args) {

    }
}
class Call {
    private Lock lock = new ReentrantLock();
}