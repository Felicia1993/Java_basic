package com.thread.demo.juc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class MatchCounterMul implements Callable<Integer> {
    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;


    public MatchCounterMul(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounterMul counterMul = new MatchCounterMul(file, keyword, pool);
                java.util.concurrent.Future<Integer> submit = pool.submit(counterMul);
            } else {
                if (search(file)) {
                    count++;
                }
            }
        }
        for (Future<Integer> result : results) {
            count += result.get();
        }
        return count;
    }

    public boolean search(File file) {
        try(Scanner in = new Scanner(file, "UTF-8")) {
            boolean found = false;
            while(!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    found = true;
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
