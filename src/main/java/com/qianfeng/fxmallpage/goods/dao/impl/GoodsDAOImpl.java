package com.qianfeng.fxmallpage.goods.dao.impl;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.commons.mybatis.MyBatisSessionFactoryUitls;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.dao.IGoodsDAO;
import com.qianfeng.fxmallpage.goods.mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsDAOImpl implements IGoodsDAO {
    @Autowired
    private SqlSession session;

    @Override
    public List<WxbGood> queryGoodByPage(Integer page) throws Exception {
        GoodsMapper goodsMapper= session.getMapper(GoodsMapper.class);
        System.out.println(goodsMapper);
        List<WxbGood> goods=goodsMapper.queryGoodByPage(page, SystemConstantsUitls.Page.pageSize);
        return goods;
    }

    @Override
    public WxbGood queryGoodById(String goodId) {
        GoodsMapper goodsMapper= session.getMapper(GoodsMapper.class);
        WxbGood good =goodsMapper.queryGoodById(goodId);
        return good;
    }

    @Override
    public void addGood(WxbGood good) {
        GoodsMapper mapper = MyBatisSessionFactoryUitls.getSession().getMapper(GoodsMapper.class);

        mapper.addGood(good);
        MyBatisSessionFactoryUitls.getSession().commit();
    }

    @Override
    public void updateGood(WxbGood good) {
        GoodsMapper mapper = MyBatisSessionFactoryUitls.getSession().getMapper(GoodsMapper.class);
        mapper.updateGood(good);
        MyBatisSessionFactoryUitls.getSession().commit();
    }

    @Override
    public void deleteGood(Integer goodId) {
        GoodsMapper mapper = MyBatisSessionFactoryUitls.getSession().getMapper(GoodsMapper.class);
        mapper.deleteGood(goodId);
        MyBatisSessionFactoryUitls.getSession().commit();
    }
}
