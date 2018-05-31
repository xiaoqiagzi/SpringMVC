package com.hzq.dao;

public interface UserDao {
    String eat();//主业务 吃饭
    void sleep();//主业务 睡觉
    //验证异常通知
    boolean login(String name,String password)throws MyException;
}
