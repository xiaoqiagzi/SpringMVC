package com.hzq.dao;

import com.hzq.bean.Provincial;

import java.io.Serializable;

public interface PDao {

    /**
     * 一级缓存
     */
    Provincial addfindByiId(Serializable id);
}
