package com.thread.demo;

public class BadSuspendDemo {
    final static Object object = new Object();
    static Thread t1 = new ChangeObjectClass("t1");
    static Thread t2 = new ChangeObjectClass("t2");
    public static class ChangeObjectClass extends Thread {
        public ChangeObjectClass(String name) {
            super.setName(name);
        }
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("in" + Thread.currentThread().getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.resume();
        t1.resume();
        t1.join();
        t2.join();

    }
}
