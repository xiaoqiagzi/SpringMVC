package com.hzq.dao;

import com.hzq.bean.Student;
import com.hzq.bean.Teacher;

import java.io.Serializable;

public interface TeacherDao {
   /*
    根据学生编号查多个老师
     */
   Student findTeacherBySid(Serializable id);
   /*
   根据老师编号查多个学生
    */
    Teacher findTeacherByTid(Serializable id);

}
