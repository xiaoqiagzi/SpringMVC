package com.hzq.bean;



public class Country {
    private  int cId;
    private  String cName;


    public Integer getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }



    public Country(int cId, String cName) {
        this.cId = cId;
        this.cName = cName;

    }

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +

                '}';
    }

}
