package com.thread.demo.juc;
public class AtomicInteger{
    /**
     * juc包中华有很多类使用了很高效的机器级指令来保证其他操作的原子性.
     * 如果有大量线程要访问相同的原子值，性能会大幅下降，因为乐观更新需要太多次重试。
     * Java8提供了LongAddr和LongAcummulator类来解决这个问题
     */


}