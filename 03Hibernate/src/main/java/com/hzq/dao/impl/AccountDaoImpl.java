package com.hzq.dao.impl;

import com.hzq.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{

    public void updateAccount(String aname, double money) {
        String sql="update account set balance=balance-? where aname=?";
        this.getJdbcTemplate().update(sql,money,aname);
    }
}
