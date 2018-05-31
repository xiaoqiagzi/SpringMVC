package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test01() {
        /**
         * 加载的主配置文件
         *  ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
         Student student= (Student) context.getBean("student");
         System.out.println(student);
         */
       /* ApplicationContext context=new ClassPathXmlApplicationContext("spring-*.xml");*/
        ApplicationContext context=new ClassPathXmlApplicationContext("spring/spring-student.xml","spring/spring-grade.xml");
        Student student= (Student) context.getBean("student");
        System.out.println(student);
    }
    }

