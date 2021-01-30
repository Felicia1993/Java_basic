package com.linkedlist.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapController {
    /**
     * 散列表hashtable：快速的查找所需要的对象
     * 散列表为每个对象计算一个整数，称为散列码hashcode
     * 自己实现hashcode方法要与equals兼容（todo：hashcode方法需补充）
     * java中，散列表通过链表数组实现，每个列表被称为桶，查找表中对象的位置，就要先计算它的散列码，然后与桶的总数取余，
     * 所得到的的结果就是保存在这个元素的桶的索引。
     *     散列冲突：遇到桶被占满的情况时，需要用新对象与桶中的所有对象进行比较，查看这个对象是否已经存在。如果散列码是合理且随机分布的，桶的数目也足够大，需要比较的次数就会很少
     * 桶的设置：元素个数的75%-150%
     * 装填因子：决定何时对散列表进行再散列，装填因子一般为0.75
     *
     */

    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>();
        long totalTime = 0;
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for(int i = 1; i <= 20; i++) {
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + "distinct words. " + totalTime + "milliseconds.");
    }
}
