package com.hzq.dao;

import com.hzq.bean.Teacher;

import java.io.Serializable;
import java.util.List;

public interface TeacherDao {
   /*
    根据老师编号查询所有导师
     */
   Teacher findTeacherById(Serializable id);
}
