package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.bean.Grade;
import com.hzq.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanTest {

    public static void main(String[] args) {
            ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
            Grade grade=  context.getBean("grade", Grade.class);
            System.out.println(grade);
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

}
