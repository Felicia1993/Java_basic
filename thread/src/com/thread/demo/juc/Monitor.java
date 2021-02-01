package com.thread.demo.juc;
public class Monitor{
    /**
     * 监视器的特性：
     *  监视器是只包含私有域的类
     *  每个监视器类的对象有一个相关的锁
     *  使用该锁对所有的方法进行加锁
     *  该锁可以有任何多个相关条件
     * java中的每个对象有一个内部的锁和内部的条件，如果一个方法用synchronized关键字声明，那么它的表现就像是一个监视器方法。通过调用wait/notifyAll/notify来访问条件变量
     *
     * java对象和监视器的区别
     *  域不要求必须是private
     *  方法不要求必须是synchronized
     *  内部锁对客户是可用的
     *
     */
}