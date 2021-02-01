package com.thread.demo.juc;

public class ReentrantLockDemo {
    /**
     * ReentrantLock保护代码块的基本结构
     * myLock.lock()//a ReentrantLock object
     * try{
     *     critical section
     * } finally{
     *     mylock.unlock
     * }
     * 锁是可重入的，锁保持一个持有计数来跟踪对lock方法的嵌套调用
     *
     * 通常，对await的调用应该是在如下的形式的循环体中
     * while(!(ok to proceed)) {
     *     condition.await();
     * }
     * 何时调用signalAll？经验上将，在对象的状态有利于等待线程的方向改变时，调用signalAll。调用signalAll不会立即激活一个等待线程。它仅仅解除了等待线程的阻塞，以便这些线程可以在当前线程退出同步方法之后，通过竞争实现对对象的访问
     *
     * 锁和条件变量的关键之处：
     *  锁用来保护代码片段，任何时刻只能允许一个线程执行被保护的代码
     *  锁可以管理试图进入被保护代码段的线程
     *  锁可以拥有一个或多个相关的条件对象
     *  每个条件对象管理那些已经被保护的代码段但还不能运行的线程
     *
     */

}
