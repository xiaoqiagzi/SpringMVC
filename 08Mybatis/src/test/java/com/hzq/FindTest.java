package com.hzq;
import com.hzq.bean.Student;
import com.hzq.bean.Teacher;
import com.hzq.dao.TeacherDao;
import com.hzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class FindTest {
    SqlSession session=null;
    TeacherDao dao=null;
    Logger log= Logger.getLogger(FindTest.class);
    @Before
    public void Before(){
        session= SessionFactoryUtil.getSession();
        dao= session.getMapper(TeacherDao.class);
    }
    @After
    public void After(){
        if(session!=null){
        }
    }
    @Test
    public void findTeacherBySid(){
        Student teacherBySid = dao.findTeacherBySid(3);
        System.out.println("老师："+teacherBySid);
        log.debug(teacherBySid);

    }
    @Test
    public void findStudentByTid(){
        Teacher teacherByTid = dao.findTeacherByTid(1);
        System.out.println("老师："+teacherByTid);
        log.debug(teacherByTid);

    }


}
