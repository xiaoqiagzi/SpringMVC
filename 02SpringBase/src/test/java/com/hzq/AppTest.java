package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("string.xml");
        Student student= context.getBean("student", Student.class);
        System.out.println(student);
        ((ClassPathXmlApplicationContext)context).close();  //关闭容器
    }

}
