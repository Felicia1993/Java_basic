package com.thread.demo.thread;

public class UnSynchBankTest {
    public static final int NACOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    private static final double MAX_AMOUNT = 1000;
    private static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACOUNTS, INITIAL_BALANCE);
        for(int i = 0; i < NACOUNTS; i++) {
            int fromAccount = i;
            Runnable r = ()->{
                try{
                    while(true) {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        try {
                            Thread.sleep((long) (DELAY * Math.random()));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
