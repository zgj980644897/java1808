package com.qianfeng.fxmallpage.goods.spring;

import com.qianfeng.fxmallpage.goods.Service.IGoodsService;
import com.qianfeng.fxmallpage.goods.Service.Impl.GoodsServiceImpl;
import com.qianfeng.fxmallpage.goods.dao.IGoodsDAO;
import com.qianfeng.fxmallpage.goods.dao.impl.GoodsDAOImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
@Component
public class SpringBeans {
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sessionFactory;
    }
    @Scope("prototype")
    @Bean
    public SqlSession getSqlSession(SqlSessionFactory sqlSessionFactory){
        SqlSession session= threadLocal.get();
        if (session==null){
            session = sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
    @Bean
    public IGoodsDAO getGoodDao() {
        IGoodsDAO dao = new GoodsDAOImpl();
        return dao;
    }

    public IGoodsService getGoodsService(){
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        return goodsService;
    }
}
