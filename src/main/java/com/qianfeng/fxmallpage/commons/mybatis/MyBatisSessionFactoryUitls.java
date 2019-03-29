package com.qianfeng.fxmallpage.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSessionFactoryUitls {
    private static  SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal =new ThreadLocal<>();
   /*饿汉单例模式*/
    /* 加载xml文件，新建sqlsessionfactory对象*/
    static {
        initSqsessionFactory();
    }
    /* 加载xml文件，新建sqlsessionfactory对象的方法*/
    public static void initSqsessionFactory(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*获得sqlSessionFactory*/
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory==null){
            initSqsessionFactory();
        }
        return sqlSessionFactory;
    }
    /*获得session连接,保证每个线程的session连接是独立的*/
    public static SqlSession getSession(){
        SqlSession session= threadLocal.get();
        if (session==null){
            session=sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

}
