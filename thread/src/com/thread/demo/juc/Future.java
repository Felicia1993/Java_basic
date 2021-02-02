package com.thread.demo.juc;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Future {
    /**
     * Runnable封装一个异步运行的任务，没有参数和返回值的异步方法。Callable和Runnable类似，有返回值，Callable接口是一个参数化的类型，只有一个方法call
     * Future保存异步计算的结果，可以启动一个计算，将Future对象交给某个线程，然后忘掉它。Future对象的所有者在结果计算好之后就可以获得它
     */
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Enter Base Directory():");
            String directory = in.nextLine();
            System.out.println("Enter keyword:");
            String keyword = in.nextLine();

            MatchCounter counter = new MatchCounter(new File(directory), keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            Thread t = new Thread(task);
            t.start();
            try {
                System.out.println(task.get() + " matching files.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
