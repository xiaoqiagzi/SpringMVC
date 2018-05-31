package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.bean.Provincial;
import com.hzq.dao.CountryDao;
import com.hzq.dao.PDao;
import com.hzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest {
    SqlSession session=null;
    CountryDao dao=null;
    Logger log= Logger.getLogger(AppTest.class);
    PDao dd=null;

    @Before
    public void Before(){
        session= SessionFactoryUtil.getSession();
        dao=session.getMapper(CountryDao.class);
        dd=session.getMapper(PDao.class);
    }
    @After
    public void After(){
        if(session!=null){
            session.commit();
            session.close();
        }
    }

    /**
     * 二级缓存
     */
    @Test
    public void findById() {
        Provincial provincialById = dao.findProvincialById(2);
        log.debug("第一次查询=======》》》》》》》"+provincialById);
        session.close();
        session=SessionFactoryUtil.getSession();
        dao=session.getMapper(CountryDao.class);
        provincialById=dao.findProvincialById(2);
        log.debug("第二次查询++++++++++》》》》"+provincialById);


    }
    @Test
    public void  addFind(){
        Provincial provincialById = dao.findProvincialById(2);
        log.debug("第一次查询=======》》》》》》》"+provincialById);
        session.close();
        session=SessionFactoryUtil.getSession();
        dao=session.getMapper(CountryDao.class);
        dao.addProvincial(new Provincial(7,"鄂尔多斯"));
        provincialById=dao.findProvincialById(2);
        log.debug("第二次查询++++++++++》》》》"+provincialById);

    }

    /**
     * 一级缓存需要注意的三点
     * 1。一级缓存一直存在，不能删除，不需要配置
     * 2.一级缓存的依据是sql语句的id+sql语句
     * 3.增删改操作会导致清空缓存
     */
    @Test
    public void find(){
        Provincial s=dd.addfindByiId(1);
        System.out.println("第一查询结果=========》》"+s);
        s=dd.addfindByiId(1);
        System.out.println("第二查询结果=========》》"+s);
    }
}
