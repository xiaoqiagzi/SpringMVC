package com.hzq.service.impl;

import com.hzq.dao.AccountDao;
import com.hzq.dao.StockDao;
import com.hzq.dao.impl.AccountDaoImpl;
import com.hzq.dao.impl.StockDaoImpl;
import com.hzq.service.BuyStockException;
import com.hzq.service.BuyStockService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyStockServiceImpl implements BuyStockService {
    //创建 账户 和股票接口的对应对象
    private AccountDao accountDao;
    private StockDao stockDao;


    public BuyStockServiceImpl() {
    }
/*
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = BuyStockException.class)
*/
    public void buyStock(String name, double money, int amount) {

        //一人减钱
        accountDao.updateAccount(name,money);
        if(1==1){
            throw new BuyStockException("购买股票失败！");
        }
        //一人加股
        stockDao.updateStock(name,amount);

    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }



    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }


}
