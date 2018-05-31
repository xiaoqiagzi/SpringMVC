package com.hzq.dao;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("小狗在啃狗头");
    }

    @Override
    public void sleep() {
        System.out.println("小狗在睡觉");
    }
}
