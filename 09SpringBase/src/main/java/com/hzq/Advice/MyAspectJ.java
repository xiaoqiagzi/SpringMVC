package com.hzq.Advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 使用注解@param
 * 当前类就是 整个程序中需要的各种系统级业务
 * 就是一个切面类
 */
public class MyAspectJ {

    public void before(){
        System.out.println("前置增强");
    }

    public void afterReturning(){
        System.out.println("后置增强");
    }
    //如果想获取方法的返回值
    public String  afterReturning(String result){
        System.out.println("后置增强........"+result);
        return "iii";

    }
    /**
     * 环绕增强可以改变返回值
     */
    public Object  around(ProceedingJoinPoint point){
        System.out.println("环绕增强进来........");
        Object result=null;
        try {
            result=  point.proceed(); //执行目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕增强出去........");
        return  "orange";
    }





}
