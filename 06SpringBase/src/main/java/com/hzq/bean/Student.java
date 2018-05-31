package com.hzq.bean;


public class Student {
        private int sId;
        private String sName;

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

    public Student() {
    }

    public Student(int sId, String sName) {
        this.sId = sId;
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                '}';
    }
}
