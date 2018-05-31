package com.hzq.dao;

public interface StockDao {
    //股票接口增加的了多少股
    void updateStock(String sname,int amount);
}
