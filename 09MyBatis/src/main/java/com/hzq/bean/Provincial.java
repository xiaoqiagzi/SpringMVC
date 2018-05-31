package com.hzq.bean;

public class Provincial {
    private int pId;
    private String pName;
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Provincial(int pId, String pName, Country country) {
        this.pId = pId;
        this.pName = pName;
        this.country = country;
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
                ", country=" + country +
                '}';
    }
}
