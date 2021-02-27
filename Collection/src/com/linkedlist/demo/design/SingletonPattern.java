package com.linkedlist.demo.design;

/**
 * 单例模式：
 * 1.类只有一个实例->private
 * 2.自行实例化并向整个系统提供实例->static
 */
public class SingletonPattern {
    public static void main(String[] args) {

    }
}

/**
 * 饿汉：类加载的时候就进行实例化
 */
/*class Single {
    private static Single singletonPattern = new Single();
    private Single() {}
    private static Single getInstance() {
        return singletonPattern;
    }

}*/
/**
 * 懒汉
 */
/*class Single {
    private static Single singletonPattern = null;
    private Single() {}
    private static Single getInstance() {
        if (singletonPattern == null) {
            singletonPattern = new Single();
        }
        return singletonPattern;
    }

}*/

/**
 * 加锁
 */
/*class Single{
    private static Single single = null;
    private synchronized static Single getInstance() {
        if (single == null) {
            single = new Single();
        }
        return single;
    }
}*/

/**
 * 双重锁检测
 */
class Single{
    private volatile static Single single = null;
    private static Single getInstance() {
        if (single == null ) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }
}
