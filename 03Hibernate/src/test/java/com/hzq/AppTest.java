package com.hzq;
import com.hzq.service.BuyStockService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {


    @Test
    public void test01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("AspectJ.xml");
        BuyStockService service=context.getBean("buyStockService",BuyStockService.class);
        service.buyStock("张三",5000.0,10);
    }
}
