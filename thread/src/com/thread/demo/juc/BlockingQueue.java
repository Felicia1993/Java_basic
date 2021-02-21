package com.thread.demo.juc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {
    /**
     * 阻塞队列是线程安全的
     * linkedBlockingQueue的容量没有上边界。但是可以指定最大容量
     * linkedBlockingDeque是双端版本
     * ArrayBlockingQueue构造时需要指定容量，并且有一个可选的参数来指定是否需要公平性。若设置了公平参数，那么等待最长时间的线程会优先得到处理
     */
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static java.util.concurrent.BlockingQueue<File> queue = new ArrayBlockingQueue<File>(FILE_QUEUE_SIZE);
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory (e.g. /opt/jdk1.8.0/src):");
            String directory = in.nextLine();
            System.out.println("Enter keyword (e.g.volatile):");
            String keyword = in.nextLine();

            Runnable enumerator = ()->{
                try {
                    enumerator(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            new Thread(enumerator).start();
            for(int i = 1; i<=SEARCH_THREADS; i++) {
                Runnable search = ()->{
                    boolean done = false;
                    while (!done) {
                        try {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else {
                                search(file, keyword);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                };
            }
        }
    }

    private static void search(File file, String keyword) throws FileNotFoundException {
        try(Scanner in = new Scanner(file, "UTF-8")) {
            int lineNumber=  0;
            while(in.hasNextLine()) {
                lineNumber++;
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
                }
            }
        }
    }

    private static void enumerator(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                enumerator(file);
            else {
                queue.put(file);
            }
        }
    }
}
