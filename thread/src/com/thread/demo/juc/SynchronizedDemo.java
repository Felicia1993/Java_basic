package com.thread.demo.juc;

public class SynchronizedDemo {
    /**
     * public synchronized void method() {
     *     method body;
     * }
     * 等价于
     * public void method() {
     *     this.intrinsicLock.lock();
     *     try{
     *         method body
     *     }
     *     finally{
     *         this.intrinsicLock.unlock();
     *     }
     * }
     * 要调用该方法，线程必须获取内部的对象锁
     * 调用wait/notifyAll等价于 intrinsicCondition.await() intrinsicCondition.signalAll()
     * synchronized局限
     *  不能中断一个正在试图获得锁的线程
     *  每个锁只有单一的条件，可能是不够的
     *  试图获得锁不能设置超时时间
     * 使用Lock和Condition对象还是同步方法？建议
     *  1.最好既不使用synchronized也不使用lock/condition，使用juc包中的一种机制，会处理所有的加锁
     *  2.synchronized适合程序就尽量使用它
     *  3.如果特别需要Lock/Condition结果提供的独有特性，才使用Lock/Condition
     */
}
