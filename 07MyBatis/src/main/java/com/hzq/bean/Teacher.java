package com.hzq.bean;

import java.util.Set;

public class Teacher {
    private int id;
    private String name;
    //一个老师可以有多的导师
    private Teacher teacher;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teacher+
                '}';
    }

    public Teacher() {
    }

    public Teacher(int id, String name, Teacher teacher) {

        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
