package com.hzq.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionFactoryUtil {
    //01创建需要单例的对象实体
    private static SqlSessionFactory sessionFactory;
    //02私有化构造
    private SessionFactoryUtil(){}
    //03对外提供访问接口
    public static synchronized SqlSession getSession(){
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis.xml");
            if(sessionFactory==null){
                sessionFactory=new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory.openSession();
    }

}
