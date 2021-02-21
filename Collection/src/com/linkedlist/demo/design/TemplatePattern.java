package com.linkedlist.demo.design;

/**
 * 行为由父类去控制，子类负责实现
 * 子类通过扩展父类，实现更灵活的操作，符合开闭原则
 * 缺点；导致类的个数增多，增加系统的复杂度
 */
public class TemplatePattern {
    public static void main(String[] args) {
        Cooking cookingFood = new CookingFood();
        cookingFood.cook();
    }
    abstract class Cooking{
        protected abstract void step1();
        protected abstract void step2();
        public void cook() {
            System.out.println("做饭开始");
            step1();
            step2();
            System.out.println("做饭结束");
        }
    }

    class CookingFood extends Cooking{

        @Override
        protected void step1() {
            System.out.println("放鸡蛋和西红柿");
        }

        @Override
        protected void step2() {
            System.out.println("少放盐");
        }
    }
}
