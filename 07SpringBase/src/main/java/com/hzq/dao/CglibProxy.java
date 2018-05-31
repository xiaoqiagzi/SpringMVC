package com.hzq.dao;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer=new Enhancer();

    /**
     * 创建代理类对象
     */
    public Object createProxy(Class clazz){
        //设置公共的接口或者父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return  enhancer.create();
    }
    /**
     * 代理类执行 委托类的 方法
     * 系统级业务进行增强
     */
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("====洗洗手====");
        Object result= methodProxy.invokeSuper(o,args);
        System.out.println("====再次洗洗手====");
        return result;
    }

    //测试代码
    public static void main(String[] args) {
        CglibProxy proxy=new CglibProxy();
        Animal dog= (Animal) proxy.createProxy(new Dog().getClass());
        dog.eat();
        System.out.println("*********************");
        dog.sleep();
    }

}

