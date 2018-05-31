package com.hzq.dao;

import com.hzq.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StudentDao {
    /*
    新增方法
     */
    void addStudent(Student student);
    /*
        新增
    */
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
     List <Student> findAllStu(Map<String,Object> map);
    /*
     根据姓名模糊查询
     */
    List<Student> selectByName(String name,int age);
    /*
    注解查询
     */
    List<Student> ch(@Param("name") String name,@Param("id") int id);
    /*
    用户输入我们不知道是什么
     */
    List<Student>  selectfindByIf(Student student);
     /*
    where 标签 替代where 1=1
     */
     List<Student>  selectfindByWhere(Student student);
    /*
     * 03.choose标签
     *  当我们的年龄不为空 按照年龄查询
     *  当我们的姓名不为空 按照姓名查询
     *  如果都会空 执行一个标签otherwise
     */
    List<Student> selectfindByChoose(Student student);
    /**
     * 04.foreach 遍历数组
     */
    List<Student> selectStudentsByForeachArray(int [] nums);
    /**
     * 05.foreach 遍历集合
     */
    List<Student> selectStudentsByForeachList(List<Integer> nums);
    /**
     * 06.foreach 遍历对象集合
     */
    List<Student> selectStudentsByForeachStudent(List<Student> students);
    /**
     * 07.foreach 遍历Map集合
     */
    List<Student> selectStudentsByForeachMap(@Param("myMap") Map<String,Object> map);
}
