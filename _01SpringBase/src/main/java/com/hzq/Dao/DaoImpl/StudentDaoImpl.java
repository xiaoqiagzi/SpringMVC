package com.hzq.Dao.DaoImpl;

import com.hzq.Dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
    public StudentDaoImpl(){
        System.out.println("studentDaoImpl的无参构造");
    }
    @Override
    public String eat() {
        System.out.println("学生正在吃苹果！！");
        return "苹果";
    }

    @Override
    public void sleep() {
        System.out.println("学生正在睡觉！！");
    }
}
