package com.hzq.service.impl;

import com.hzq.bean.Student;
import com.hzq.dao.StudentDao;
import com.hzq.service.Studentservice;

import java.io.Serializable;
import java.util.List;

public class StudentServerImpl  implements Studentservice {
    private  StudentDao dao;

    public StudentDao getDao() {
        return dao;
    }

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    public int addStudent(Student student) {
        return dao.addStudent(student);
    }


    public int delStudent(Serializable id) {
        return dao.delStudent(id);
    }


    public int updateStudent(Student student) {
        return dao.updateStudent(student);
    }


    public List<Student> findAllStudents() {
        return dao.findAllStudents();
    }
}
