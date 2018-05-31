package com.hzq.dao;

import com.hzq.bean.Country;
import com.hzq.bean.Provincial;

import java.util.List;

public interface CountryDao {
    /**
     * 根据省会的id查询对应的省会和国家
     */
    Provincial findProvincialById(int id);
}
