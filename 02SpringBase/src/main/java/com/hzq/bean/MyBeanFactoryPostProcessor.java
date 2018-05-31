package com.hzq.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public MyBeanFactoryPostProcessor() {
        System.out.println("===MyBeanFactoryPostProcessor的无参构造方法 ===");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("===MyBeanFactoryPostProcessor的postProcessBeanFactory ===");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("student");
        beanDefinition.getPropertyValues().addPropertyValue("stuName","小白");


    }
}
