package com.hzq;

import com.hzq.bean.Provincial;
import com.hzq.dao.CountryDao;
import com.hzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class AppTest {
    CountryDao dao = null;
    SqlSession session=null;
    Logger log = Logger.getLogger(AppTest.class);
    @Before
    public void before(){
        session= SessionFactoryUtil.getSession();
        dao=session.getMapper(CountryDao.class);
    }
    @After
    public void after(){
        if(session!=null) {
            session.close();
        }
    }

    @Test
    public void  fingCountry(){
        Provincial provincialById = dao.findProvincialById(2);
        log.trace("获取省会名称执行一次"+provincialById.getpName());
        log.trace("获取省会名称执行两次"+provincialById.getCountry().getcName());
        log.trace("获取省会名称执行两次"+provincialById.getCountry());
    }


}
