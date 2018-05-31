package com.hzq.bean;

import java.util.Set;

public class Teacher {
    private int id;
    private String name;
    //一个老师可以有多个学生
    private Set<Student> students;

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher() {
    }

    public Teacher(int id, String name, Set<Student> students) {

        this.id = id;
        this.name = name;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
