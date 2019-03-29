package com.qianfeng.fxmallpage.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisSessionFactoryUtils2 {
    private  static SqlSessionFactory sqlSessionFactory;
    private  static  ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
    static {
        initSqlSessionFactory();
    }
    public static void initSqlSessionFactory(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory==null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory;
    }
    public  static SqlSession getSqlsession(){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession==null){
            sqlSession=sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
}
