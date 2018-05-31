package com.hzq.service;

import com.hzq.bean.Student;

import java.io.Serializable;
import java.util.List;

public interface Studentservice {
    int  addStudent(Student student);
    int  delStudent(Serializable id);
    int  updateStudent(Student student);
    List<Student> findAllStudents();
}
