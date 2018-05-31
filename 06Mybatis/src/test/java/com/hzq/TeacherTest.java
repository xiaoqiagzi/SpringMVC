package com.hzq;
import com.hzq.bean.Teacher;
import com.hzq.dao.TeacherDao;
import com.hzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class TeacherTest{
        SqlSession session= null;
        TeacherDao dao=null;
        Logger log=Logger.getLogger(TeacherTest.class);

        @Before
        public void Before(){
            session=SessionFactoryUtil.getSession();
            log.trace(session);
            dao=session.getMapper(TeacherDao.class);

        }
        @After
        public void After(){
            if(session!=null) {
                session.close();
            }
        }
        @Test
        public void findTeacherByTid(){
            List<Teacher> teacher = dao.findTeacherByTid(2);
            log.trace(teacher);
        }
        @Test
        public void findTeacherById(){
            Teacher teachers = dao.findTeacherById(1);
            log.debug(teachers);
        }
    }


