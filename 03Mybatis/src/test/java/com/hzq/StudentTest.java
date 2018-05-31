package com.hzq;

import com.hzq.bean.Student;
import com.hzq.dao.StudentDao;
import com.hzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {

    StudentDao dao = null;
    SqlSession session=null;
    Logger log = Logger.getLogger(StudentTest.class);

    @Before
    public void before() {
        session= SessionFactoryUtil.getSession();
        dao=session.getMapper(StudentDao.class);

    }
    @After
    public void after(){
        session.close();
    }
    @Test
    public void findById(){
        Student student=dao.findById(1000);
        log.trace(student);
    }
    @Test
    public  void findAll(){
        List<Student> student=dao.findAll();
        log.trace(student);
    }
    @Test
    public void mapfindAll(){
        Map<String,Object> map= new HashMap<>();
        map.put("name","张");
        map.put("age",16);
        Student student =new Student();
        student.setId(1000);
        student.setName("张无忌");
        map.put("student",student);
        List<Student> list=dao.findAllStu(map);
        log.trace(list);
    }
    @Test
    public void selectByName(){

        List<Student> list=dao.selectByName("小龙女",16);
        log.debug(list);

    }
    @Test
    public void cha(){
        List<Student> list =dao.ch("张三丰",1005);
        log.debug(list);
    }
    @Test
    public  void selectfindByIf(){
        Student student =new Student();
        student.setName("张");
        student.setAge(18);
        List<Student> list=dao.selectfindByIf(student);
        log.debug(list);

    }
    @Test
    public  void selectfindByWhere(){
        Student student =new Student();
        student.setName("张");
        student.setAge(18);
        List<Student> list=dao.selectfindByWhere(student);
        log.debug(list);

    }
    @Test
    public void findChoose(){
        Student student =new Student();
        student.setName("黄");
        student.setAge(17);
        List<Student> list = dao.selectfindByChoose(student);
        log.debug(list);
    }
    @Test
    public void findArray(){
        int[] num={1000,1001,1002};
        List<Student> students=dao.selectStudentsByForeachArray(num);
        log.debug(students);
    }
    @Test
    public void findList(){
        List<Integer> students=new ArrayList<Integer>();
        students.add(1006);
        students.add(1007);
        students.add(1008);
        List<Student> list = dao.selectStudentsByForeachList(students);
        log.trace(list);

    }
    @Test
    public void findStudent(){
            List<Student> students=new ArrayList<Student>();
            Student student=new Student();
            Student student1=new Student();
            student.setId(1010);
            student1.setId(1012);
            students.add(student);
            students.add(student1);
            List<Student> stu = dao.selectStudentsByForeachStudent(students);
            log.trace(stu);
    }
    @Test
    public void findMap(){
        Map<String ,Object> map  =new HashMap<>();
       Student student=new Student();
        student.setId(1011);
        Student student1=new Student();
        student1.setId(1012);
        map.put("1000",1001);
        map.put("1011",1011 );
        List<Student> maps = dao.selectStudentsByForeachMap(map);
        log.trace(maps);

    }
}