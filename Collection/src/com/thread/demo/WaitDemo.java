package com.thread.demo;

public class WaitDemo {
    final static Object object = new Object();
    public static class ThreadA extends Thread {

        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("A");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static class ThreadB extends Thread {

        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println('B');
                    object.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadA();
        Thread t2 = new ThreadB();
        t1.start();
        t2.start();
    }
}
