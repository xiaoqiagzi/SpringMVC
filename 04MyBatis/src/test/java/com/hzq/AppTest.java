package com.hzq;
import com.hzq.bean.Country;
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

    /**
     * 没有延迟加载
     */
    @Test
    public void selectCoutryBy() {
       Country country= dao.selectCoutryByIf(1);
       log.debug(country);

    }

    /**
     * 延迟加载
     */
    @Test
    public void  selectCountryByCid(){
        Country countries =dao.selectCountryByCid(1);
        System.out.println(countries.getcName());
        log.trace("查询的结果是:"+countries.getProvincials());
        log.trace("查询的结果是:"+countries.getcName());


    }

}
