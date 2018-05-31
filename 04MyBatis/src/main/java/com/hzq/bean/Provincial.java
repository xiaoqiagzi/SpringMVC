package com.hzq.bean;

public class Provincial {
    private int pId;
    private String pName;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Provincial(int pId, String pName) {
        this.pId = pId;
        this.pName = pName;
    }

    public Provincial() {
    }

    @Override
    public String toString() {
        return "Provincial{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                '}';
    }
}
