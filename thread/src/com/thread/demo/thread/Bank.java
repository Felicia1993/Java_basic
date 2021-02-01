package com.thread.demo.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock myLock;
    private Condition sufficientFunds ;
    public Bank(int n, double initBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initBalance);
        myLock = new ReentrantLock();
        sufficientFunds = myLock.newCondition();
    }
   /* public void transfer(int from , int to, double amount) {

        myLock.lock();
        try{
            System.out.println(Thread.currentThread());
            while (accounts[from]  < amount) {
                //wait
                sufficientFunds.await();//当前线程被阻塞，放弃锁
            }
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from ,to);
            accounts[to] += amount;
            sufficientFunds.signalAll(); //
            System.out.printf("total Balance: %10.2f%n", getTotalBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }

    }*/

    public synchronized void transfer(int from , int to, double amount) throws InterruptedException {

        while (accounts[from]  < amount) {
            wait();
        }
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from ,to);
        accounts[to] += amount;
        sufficientFunds.notifyAll(); //
        System.out.printf("total Balance: %10.2f%n", getTotalBalance());
    }


    /*public double getTotalBalance() {
        myLock.lock();
        try{
            double sum = 0;
            for (double a : accounts) {
                sum +=a;
            }
            return sum;
        } finally {
            myLock.unlock();
        }
    }*/

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) {
            sum +=a;
        }
        return sum;

    }


    public int size() {
        return accounts.length;
    }
}
