package com.hzq.bean;

import java.util.Set;

public class Student {
    private int sId;
    private String sName;
    //一个学生对应多个老师
    private Set<Teacher> teachers;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Student(int sId, String sName, Set<Teacher> teachers) {
        this.sId = sId;
        this.sName = sName;
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", teachers=" + teachers +
                '}';
    }

    public Student() {
    }
}
