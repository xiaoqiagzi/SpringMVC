package com.hzq;
import com.hzq.bean.Student;
import com.hzq.dao.StudentDao;
import com.hzq.dao.StudentDaoImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentTest {
    StudentDao dao = null;
    Logger log = Logger.getLogger(StudentTest.class);

    @Before
    public void before() {
        dao = new StudentDaoImpl();
    }

    @Test
    public void addStudent() {
        Student student = new Student(55, "小黑");
        log.debug("insert之前的编号" + student.getId());
        dao.addStudent(student);
        log.debug("insert之后的编号" + student.getId());
    }

    @Test
    public void addStudentByCache() {
        Student student = new Student(55, "小黑111");
        log.debug("insert之前的编号" + student.getId());
        dao.addStudentByCache(student);
        log.debug("insert之后的编号" + student.getId());

    }

    /*
    删除数据库
     */
    @Test
    public void deleteStudent() {
        dao.deleteStudent(12);
    }

    /*
    修改数据库
     */
    @Test
    public void updateStudent() {
        Student student = new Student(9, "哈哈", 33);
        dao.updateStudent(student);
    }
    /*
      id查询
     */
    @Test
    public void findById() {

    Student student=dao.findById(4);
    log.trace(student);

    }
    /*
    List 集合
     */
    @Test
    public  void listStudent(){
        List<Student> student=dao.findAll();
        log.debug(student);
    }
    /*
    map集合
     */
    @Test
    public  void mapStudent(){
        Map<String,Object> students=dao.findAllStu();
        log.trace(students.size());
        log.debug(students.get("嘿嘿"));
    }
    @Test
    public void selectByName(){
        List<Student> students=dao.selectByName("嘿嘿");
        log.trace(students);
    }


}