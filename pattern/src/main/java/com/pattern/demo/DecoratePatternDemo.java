package com.pattern.demo;

/**
 * 对一个类/对象增加新的功能有两种方式
 *  1.继承
 *  2.关联机制--装饰器模式
 *  区别
 *  1.继承模式是静态的，必须要实现一个新的子类，对类的层级进行扩展
 *  2.装饰器模式是动态的，拿到一个对象就可以进行扩展，不需要修改原逻辑
 *
 *  装饰模式的概念：
 *  动态地给一个对象添加一些额外的功能，就增加功能来说，装饰器比继承更灵活
 *  java IO 使用了大量的装饰器模式
 *
 */
public class DecoratePatternDemo {
    public static void main(String[] args) {
        new RobotDecorate(new FirstRoot()).doMoreThing();
    }
}

interface Robot {
    void doSomething();
}

class FirstRoot implements Robot {
    @Override
    public void doSomething() {
        System.out.println("对话");
        System.out.println("唱歌");
    }
}

class  RobotDecorate implements Robot {

    private Robot robot;

    public RobotDecorate(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMoreThing() {
        robot.doSomething();
        System.out.println("跳舞、拖地");
    }
}

