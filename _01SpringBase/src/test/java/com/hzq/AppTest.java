package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.Service.ServerImpl.StudentServerImpl;
import com.hzq.Service.StudentService;
import com.hzq.bean.Student;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.beans.AppletInitializer;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test01(){
        StudentService ss = new StudentServerImpl();
        ss.sleep();
    }
    /**
     * Spring容器的工作：
     * 01.创建各种bean对象
     * 02.管理bean之间的关系
     *
     *ApplicationContext接口有个实现类
     * ClassPathXmlApplicationContext("spring.xml")
     *   特点：
     *   spring.xml文件中配置的所有bean都实例化了！
     */
    @Test
    public void test02(){
        //通过spring容器来 实例化service层对象
        ApplicationContext context=new
                ClassPathXmlApplicationContext("string.xml");
        System.out.println("===================");
        StudentService service= (StudentService) context.getBean("studentService");
        service.sleep();
    }
    /**
     * 实现按需加载  不是把核心文件中配置的所有bean都实例化！
     */
    @Test
    public void test03(){
        //通过spring容器来 实例化service层对象
        XmlBeanFactory context=new XmlBeanFactory(new
                ClassPathResource("string.xml"));
        System.out.println("===================");
        //spring.xml文件中bean的id
        StudentService service= (StudentService) context.getBean("studentService");
        service.sleep();
    }
    /**
     * 从某个位置获取核心配置文件
     */

    @Test
    public void test04(){
        //通过spring容器来 实例化service层对象
        ApplicationContext context=new
                FileSystemXmlApplicationContext("E:/U3IDEA/spring.xml");
        System.out.println("===================");
        StudentService service= (StudentService) context.getBean("studentService");
        service.sleep();
    }
    /**
     * 验证单例模式
     * 所有由spring容器创建出来的对象 默认都是单例的
     */

    @Test
    public void test05(){
    ApplicationContext context=new
            ClassPathXmlApplicationContext("string.xml");
        System.out.println("===================");
        Student stu1= (Student) context.getBean("student");
        System.out.println(stu1);
        Student stu2= (Student) context.getBean("student");
        System.out.println(stu2);

    }
}

