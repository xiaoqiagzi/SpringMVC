package com.hzq.dao;

import com.hzq.bean.Country;

import java.util.List;

public interface CountryDao {
    /**
     * 根据国家id查国家以及省会
     */
    Country selectCoutryByIf(int id);
    /**
     * 延迟加载
     */
    Country selectCountryByCid(int id);
}
