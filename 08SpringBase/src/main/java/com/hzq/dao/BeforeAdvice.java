package com.hzq.dao;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdvice implements MethodBeforeAdvice {
    /**
     * 在目标执行方法之前执行
     * @param method  目标方法
     * @param objects 方法中的参数列表
     * @param o     目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        /*System.out.println("目标对象==="+target);*/
        System.out.println("method目标方法"+method.getName());
        System.out.println("执行的*****前置通知***");
    }
}
