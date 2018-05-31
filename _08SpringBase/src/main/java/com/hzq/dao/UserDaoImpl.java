package com.hzq.dao;

public class UserDaoImpl implements UserDao {
    public String eat() {
        System.out.println("正在吃.........");
        return "苹果";
    }

    public void sleep() {
        System.out.println("正在睡觉");

    }
}
