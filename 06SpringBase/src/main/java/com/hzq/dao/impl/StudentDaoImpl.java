package com.hzq.dao.impl;
import com.hzq.bean.Student;
import com.hzq.dao.StudentDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    /**
     * dao的实现类
     * 书写sql
     * JdbcDaoSupport====>BaseDao
     * JdbcDaoSupport有两个重要的属性
     * 01.jdbcTemplate    模版
     * 02.需要 dataSource  ===>数据源
     * <p>
     * JdbcDaoSupport  所有的增删改 都是update
     * 查询是query
     */
    public int addStudent(Student student) {
        String sql = "INSERT INTO `springstu` VALUE (?,?)";
        return getJdbcTemplate().update(sql, student.getsId(), student.getsName());
    }

    public int delStudent(Serializable id) {
        String sql = "DELETE  FROM `springstu` WHERE sid=?;";
        return getJdbcTemplate().update(sql, id);
    }

    public int updateStudent(Student student) {
        String sql = "update springstu set sname=?  where sid=?";
        return getJdbcTemplate().update(sql,  student.getsName(),student.getsId());
    }

    public List<Student> findAllStudents() {
        String sql = "select * from springstu";
        return getJdbcTemplate().query(sql,new RowMapper<Student>(){
            /**
             * 这里的ResultSet是返回一个对象！
             * 我们之前使用的是 一个结果集！
             */
            public Student mapRow (ResultSet rs,int rowNum) throws SQLException {
                //创建student对象  依次返回
                Student student = new Student();
                student.setsId(rs.getInt("sid"));
                student.setsName(rs.getString("sname"));
                return student;
            }
        });

    }

}