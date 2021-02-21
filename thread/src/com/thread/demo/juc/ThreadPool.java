package com.thread.demo.juc;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadPool {
    /**
     * newCachedThreadPool:必要时创建线程；空闲线程会保留60s
     * newFixedThreadPool:包含固定数量的线程，空闲线程会一直保留
     * newSingleThreadExecutor:只有一个线程的池，该线程顺序执行每个提交的任务
     * newScheduledThreadPool:用于预定执行而构建的固定线程池，替代java.util.Timer
     * newSingleThreadScheduledExecutor:用于预订执行而构建的单线程的池
     *
     * 在使用连接池应该做的事情
     * 1.调用Excutors类中静态方法newCachedThreadPool或newFixedThreadPool
     * 2.调用submit提交Runnable或Callable对象
     * 3.如果想要取消一个任务，如果提交Callable对象，就要保存好返回的Future对象
     * 4.当不再提交任何任务时，调用shutdown
     *
     */

    public static void main(String[] args) {
        try(
            Scanner in = new Scanner(System.in)) {
            System.out.println("Enter Base Directory():");
            String directory = in.nextLine();
            System.out.println("Enter keyword:");
            String keyword = in.nextLine();
            ExecutorService pool = Executors.newCachedThreadPool();

            MatchCounterMul counter = new MatchCounterMul(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);

            try {
                System.out.println(result.get() + " matching files.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            pool.shutdown();
        }
    }

}
