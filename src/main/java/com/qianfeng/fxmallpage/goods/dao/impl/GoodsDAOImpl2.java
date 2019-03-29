package com.qianfeng.fxmallpage.goods.dao.impl;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.commons.mybatis.MybatisSessionFactoryUtils2;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.dao.IGoodsDAO;
import com.qianfeng.fxmallpage.goods.mapper.GoodsMapper;
import com.qianfeng.fxmallpage.goods.mapper.GoodsMapper2;

import java.util.List;

public class GoodsDAOImpl2 implements IGoodsDAO {

    @Override
    public List<WxbGood> queryGoodByPage(Integer page) throws Exception {
        GoodsMapper2 goodsMapper2= MybatisSessionFactoryUtils2.getSqlsession().getMapper(GoodsMapper2.class);
        List<WxbGood> goods = goodsMapper2.queryGoodsByPage(page, SystemConstantsUitls.Page.pageSize);

        return goods;
    }
}
