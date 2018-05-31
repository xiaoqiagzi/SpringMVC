package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.dao.UserDao;
import com.hzq.service.UserService;
import com.hzq.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void spring() {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        UserService service=context.getBean("userService",UserService.class);
        service.eat();
        service.sleep();
    }
    @Test
    public void beanName() {
        ApplicationContext context=new ClassPathXmlApplicationContext("beanName.xml");
        UserService service=context.getBean("userService",UserService.class);
        service.eat();
        service.sleep();
    }

    @Test
    public  void  defaultTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("zjspring.xml");
        UserDao dao= context.getBean("userDao", UserDao.class);
         //System.out.println(dao.eat());
        dao.sleep();
    }

}
