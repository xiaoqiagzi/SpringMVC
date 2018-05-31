package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    @Test
    public  void  aspectJTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
        UserDao dao= context.getBean("userDao", UserDao.class);
        //System.out.println(dao.eat());
        dao.sleep();
    }

}
