package com.hzq.dao;

import com.hzq.bean.Student;

import java.io.Serializable;
import java.util.List;

public interface StudentDao {
    int  addStudent(Student student);
    int  delStudent(Serializable id);
    int  updateStudent(Student student);
    List<Student> findAllStudents();
}
