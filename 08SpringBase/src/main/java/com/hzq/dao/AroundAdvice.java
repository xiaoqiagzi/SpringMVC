package com.hzq.dao;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {
    /**
     * invoke :在前置通知之后，后置通知之前执行
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object result=methodInvocation.proceed();
        if(result!=null){
            result ="两个馒头";
        }
        System.out.println("方法执行之后  环绕通知");
        return result;
    }


}
