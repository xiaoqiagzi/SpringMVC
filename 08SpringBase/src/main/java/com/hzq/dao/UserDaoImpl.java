package com.hzq.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public String eat() {
        System.out.println("正在吃饭eat.....");
        return "馒头";
    }

    @Override
    public void sleep() {
        System.out.println("正在睡觉");

    }

    @Override
    public boolean login(String name, String password) {
        if(!"admin".equals(name)){
            throw new MyException("账号错误");
        }
        if(!"admin".equals(password)){
            throw new MyException("密码错误");
        }
        return true;
    }
}
