package com.thread.demo.juc;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class MatchCounter implements Callable<Integer> {
    private File directory;
    private String keyword;

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        File[] files = directory.listFiles();
        List<FutureTask<Integer>> results = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounter counter = new MatchCounter(file, keyword);
                FutureTask<Integer> task = new FutureTask<>(counter);
                results.add(task);
                Thread thread = new Thread(task);
                thread.start();
            } else {
                if (search(file)) {
                    count++;
                }
            }
        }
        for (FutureTask<Integer> result : results) {
            count = result.get();
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
