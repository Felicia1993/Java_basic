package com.linkedlist.demo.design;

/**
 * 责任链模式的优点：将请求和处理分开，请求者不需要知道谁去处理，处理者也不需要知道请求的全貌
 * 提高系统灵活性，新增处理器到链条中代价很小
 * 缺点：降低系统性能，当链路比较长的时候，性能会大幅下降，不利于调试，采取了类似递归的方式
 */
public class ChainPattern {
    public static void main(String[] args) {
        Handler level1 = new Leader();
        Handler level2 = new Boss();
        level1.setNextHandler(level2);
        level1.process(10);
        level1.process(11);

    }

}
abstract class Handler{
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void process(Integer info);
}

class Leader extends Handler {

    @Override
    public void process(Integer info) {
        if (info < 11 && info > 0) {
            System.out.println("Leader 处理");
        } else {
            nextHandler.process(info);
        }
    }
}

class Boss extends Handler {

    @Override
    public void process(Integer info) {
        System.out.println("Boss处理！");
    }
}