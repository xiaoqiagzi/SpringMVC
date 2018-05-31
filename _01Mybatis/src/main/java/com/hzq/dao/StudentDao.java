package com.hzq.dao;

import com.hzq.bean.Student;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    /*
    新增方法
     */
    void addStudent(Student student);

    void addStudentByCache(Student student);

    /*
    删除方法
     */
    void deleteStudent(Serializable id);
    /*
    修改方法
     */
    void updateStudent(Student student);
    /*
    查询id
     */
    Student findById(Serializable id);
    /*
    查询所有
     */
    List<Student>  findAll();
    /*
    查询所有返回map集合
     */
    Map<String ,Object> findAllStu();
    /*
     根据姓名模糊查询
     */
    List<Student> selectByName(String name);
}
