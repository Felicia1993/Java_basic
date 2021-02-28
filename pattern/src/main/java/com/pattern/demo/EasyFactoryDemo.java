package com.pattern.demo;

import java.text.DateFormat;

/**
 * 简单工厂模式又称为静态工厂方法模式，它属于类创建型模式，在简单工厂模式中，可以根据参数的不同返回不同类的实例。简单工厂模式专门定义一个类来负责创建其他类的实例
 * 被创建的实例通常都具有共同的父类
 */
public class EasyFactoryDemo {
    /**
     * 优点：实现对象的创建和使用分离，创建完全交给专门的工厂负责
     * 缺点：不够灵活
     *
     * @param type
     * @return
     */
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product product = EasyFactoryDemo.createProduct("A");
        product.print();
    }
}
abstract class Product{
    public abstract void print();
}
class ProductA extends Product {

    @Override
    public void print() {
        System.out.println("productA");
    }
}

class ProductB extends Product {

    @Override
    public void print() {
        System.out.println("productA");
    }
}
