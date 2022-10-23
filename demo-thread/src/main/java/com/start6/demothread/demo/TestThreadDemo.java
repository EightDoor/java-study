package com.start6.demothread.demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 周凯
 * @date 2022/10/23
 */
public class TestThreadDemo {
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        ReentrantLock reentrantLock = new ReentrantLock();
        while (true) {
            Thread thread = new Thread(() -> {
                try {
                    reentrantLock.lock();
                    System.out.println("线程启动了");
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            });

            thread.start();
        }
    }
}
