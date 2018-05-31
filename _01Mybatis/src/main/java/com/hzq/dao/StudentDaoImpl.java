package com.hzq.dao;

import com.hzq.bean.Student;
import com.hzq.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {


    @Override
    public void deleteStudent(Serializable id) {
        //获取session
        SqlSession session=null;
        try {
            session=SessionFactoryUtil.getSession();
            session.insert("deleteStudent",id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public void updateStudent(Student student) {
        SqlSession session=null;
        try {
            session=SessionFactoryUtil.getSession();
            session.update("updateStudent",student);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }


    }

    @Override
    public Student findById(Serializable id) {
        SqlSession session=null;
        Student student=null;
        try {
            session=SessionFactoryUtil.getSession();
            student=session.selectOne("findById",id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
            return  student;
    }

    @Override
    public List<Student> findAll() {
        SqlSession session=null;
        List<Student> students=null;
        try {
            session=SessionFactoryUtil.getSession();
            students=session.selectList("findAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return students;
    }

    @Override
    public Map<String, Object> findAllStu() {
        SqlSession session=null;
        Map<String,Object> map=null;
        try {
            session=SessionFactoryUtil.getSession();
            map=session.selectMap("findAllStu","name");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return map;
    }

    /**
     * 模糊查询
     */
    @Override
    public List<Student> selectByName(String name) {
        SqlSession session=null;
        List<Student> students=null;
        try {
            session=SessionFactoryUtil.getSession();
            students=session.selectList("selectByName","name");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return students;
    }

    /**
         * @param student  需要新增的学生对象
         */
        @Override
        public void addStudent(Student student) {
            //获取session
            SqlSession session = null;
            try {
                session= SessionFactoryUtil.getSession();

                session.insert("addStudent",student);
                //手动提交事务
                session.commit();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //务必要关闭session
                session.close();
            }

        }

        /**
         * 新增  并且获取新增对象的id
         */
        public void addStudentByCache(Student student) {
            //获取session
            SqlSession session = null;
            try {
                session= SessionFactoryUtil.getSession();
                session.insert("addStudentByCache",student);
                //手动提交事务
                session.commit();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //务必要关闭session
                session.close();
            }
        }
    }

