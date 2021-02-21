package com.linkedlist.demo.design;

public class ProxyPattern {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        new RealSubjectProxy().doWork();
    }
}

interface Subject{
    void doWork() throws ClassNotFoundException, InstantiationException, IllegalAccessException;
}
//真正目标类
class RealSubject implements Subject {

    @Override
    public void doWork() {
        System.out.println("hello world");
    }
}
//建立代理类和目标类的关系
class RealSubjectProxy implements Subject{
    private RealSubject subject;
    public RealSubjectProxy() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.subject = (RealSubject) this.getClass().getClassLoader().loadClass("com.linkedlist.demo.design.ProxyPattern").newInstance();
    }

    public void connect() {
        System.out.println("建立连接");
    }

    public void log() {
        System.out.println("日志记录");
    }
    @Override
    public void doWork() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        connect();
        subject.doWork();
        log();
    }
}