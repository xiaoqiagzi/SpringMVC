package com.hzq.dao;
import org.springframework.aop.AfterReturningAdvice;
import java.lang.reflect.Method;

public class AfterAdvice implements AfterReturningAdvice {
    /**
     * 在目标方法执行之后 执行
     * @param o
     * @param method
     * @param objects
     * @param o1
     * @param
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了****后置通知****");
        /*System.out.println("返回值"+returnValue);*/
    }
}
