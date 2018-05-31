package com.hzq.dao.impl;

import com.hzq.dao.StockDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockDaoImpl extends JdbcDaoSupport implements StockDao {
    public void updateStock(String sname, int amount) {
        String sql="update stock set amount=amount+? where sname=?";
        this.getJdbcTemplate().update(sql,amount,sname);

    }
}
