package com.thread.demo.juc;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ConcurrentHashMap {
    /**
     * 线程安全的集合：这些集合使用复杂的算法，通过允许并发地访问数据结构的不同部分来竞争极小化
     * 映射条目的原子更新：
     *
     */
    public static void main(String[] args) {
        String word = "";
        HashMap<String, Long> hash = new HashMap<>();
        Long oldValue = hash.get(word);
        Long newValue = oldValue == null ? 1 : oldValue + 1;//非线程安全
        hash.put(word, newValue);
        //=======变为线程安全方法1==============
        HashMap<String, AtomicLong> hash1 = new HashMap<>();
        //=======变为线程安全方法2==============
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

}
