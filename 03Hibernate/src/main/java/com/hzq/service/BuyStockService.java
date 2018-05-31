package com.hzq.service;

public interface BuyStockService {
    //谁花了多少钱 购买了 多少股票
    void buyStock(String name,double money,int amount);
}
