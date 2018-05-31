package com.hzq.Service.ServerImpl;

import com.hzq.Dao.StudentDao;
import com.hzq.Service.StudentService;

public class StudentServerImpl implements StudentService {
    public StudentServerImpl(){
        System.out.println("studentDaoImpl的无参构造");
    }
    StudentDao dao;


    //DI依赖注入
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }
    @Override
    public String eat() {
        System.out.println("开启日志");
        String restule=dao.eat();
        System.out.println("关闭日志");
        return restule;
    }

    @Override
    public void sleep() {
        System.out.println("开启日志");
        dao.sleep();
        System.out.println("关闭日志");
    }


}
