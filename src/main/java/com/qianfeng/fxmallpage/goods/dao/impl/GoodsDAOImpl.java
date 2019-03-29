package com.qianfeng.fxmallpage.goods.dao.impl;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.commons.mybatis.MyBatisSessionFactoryUitls;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.dao.IGoodsDAO;
import com.qianfeng.fxmallpage.goods.mapper.GoodsMapper;

import java.util.List;

public class GoodsDAOImpl implements IGoodsDAO {

    @Override
    public List<WxbGood> queryGoodByPage(Integer page) throws Exception {
        GoodsMapper goodsMapper= MyBatisSessionFactoryUitls.getSession().getMapper(GoodsMapper.class);
        System.out.println(goodsMapper);
        List<WxbGood> goods=goodsMapper.queryGoodByPage(page, SystemConstantsUitls.Page.pageSize);
        return goods;
    }
}
