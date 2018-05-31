package com.hzq.bean;

import java.util.Set;

public class Teacher {
    private int id;
    private String name;
    //一个老师可以有多的导师
    private Set<Teacher> teachers;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }

    public Teacher() {
    }

    public Teacher(int id, String name, Set<Teacher> teachers) {

        this.id = id;
        this.name = name;
        this.teachers = teachers;
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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
