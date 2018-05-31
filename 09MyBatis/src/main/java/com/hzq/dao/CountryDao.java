package com.hzq.dao;

import com.hzq.bean.Provincial;

import java.io.Serializable;

public interface CountryDao {
    /**
     * 根据省会的id查询对应的省会和国家
     */
    Provincial findProvincialById(int id);

    void addProvincial(Provincial provincial);

    /**
     * 一级缓存
     */
    Provincial  addfindByiId(Serializable id);
}
