package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.bean.Student;
import com.hzq.service.Studentservice;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple Student.
 */
public class AppTest {
    ApplicationContext context=null;
    Studentservice service=null;
    @Before
    public void before(){
        context=new ClassPathXmlApplicationContext("spring.xml");
        service=context.getBean("studentService",Studentservice.class);
    }
    @Test
    public void add() {
        service.addStudent(new Student(1,"小白白"));
    }
    @Test
    public void del(){
        service.delStudent(22);
    }
    @Test
    public void update(){
        service.updateStudent(new Student(22,"小白白"));
    }
    @Test
    public void getAll(){
        List<Student> allStudents = service.findAllStudents();
        for (Student s:allStudents) System.out.println(s);



    }
}
