package com.hzq.service;

public interface ExceptionService{
//验证异常通知的接口
    public  boolean  checkUser(String  userName,int age) throws UserException;
}

