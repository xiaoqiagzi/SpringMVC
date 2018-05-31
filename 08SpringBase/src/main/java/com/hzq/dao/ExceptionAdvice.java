package com.hzq.dao;

import com.hzq.service.AgeException;
import com.hzq.service.UserNameException;
import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice {
    /**
     * @param ex 用户异常
     */
    public void afterThrowing(UserNameException ex){
        System.out.println(ex.getMessage());
    }
    /**
     * @param ex 年龄异常
     */
    public  void  afterThrowing(AgeException ex){
        System.out.println(ex.getMessage());
    }
    public void afterThrowing(MyException ex){
        System.out.println("进入了 异常通知");
        System.out.println(ex.getMessage());
    }
}
