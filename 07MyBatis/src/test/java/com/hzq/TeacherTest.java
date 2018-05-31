package com.hzq;

import static org.junit.Assert.assertTrue;

import com.hzq.bean.Teacher;
import com.hzq.dao.TeacherDao;
import com.hzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class TeacherTest
{
    SqlSession session=null;
    TeacherDao dao =null;
    Logger log=Logger.getLogger(TeacherTest.class);
    @Before
    public void Before(){
       session= SessionFactoryUtil.getSession();
       dao=session.getMapper(TeacherDao.class);
    }
    @After
    public  void After(){
        if(session!=null){
            session.close();
        }
    }
    @Test
    public void findById() {
        Teacher teacherById = dao.findTeacherById(6);
        log.debug(teacherById);
        System.out.println("查询结果=======>"+teacherById);
    }
}
