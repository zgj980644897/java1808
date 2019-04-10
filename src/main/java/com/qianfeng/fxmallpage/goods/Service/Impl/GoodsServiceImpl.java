package com.qianfeng.fxmallpage.goods.Service.Impl;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.goods.Service.IGoodsService;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.dao.IGoodsDAO;
import com.qianfeng.fxmallpage.goods.dao.impl.GoodsDAOImpl;
import com.qianfeng.fxmallpage.goods.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<WxbGood> queryGoodByPage(Integer page) throws Exception {
        if (page < 1) {
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        Integer index=(page-1)* SystemConstantsUitls.Page.pageSize;
        List<WxbGood> goodList= goodsMapper.queryGoodByPage(index,SystemConstantsUitls.Page.pageSize);
        System.out.println("**********"+goodList);
        return goodList;
    }

    @Override
    public WxbGood queryGoodById(String goodId) {
        return goodsMapper.queryGoodById(goodId);
    }

    @Override
    public void addGood(WxbGood good) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String sub=s.substring(0,8);
        good.setGoodId(sub);
        goodsMapper.addGood(good);
    }

    @Override
    public void update(WxbGood good) {
        goodsMapper.updateGood(good);
    }

    @Override
    public void delect(Integer goodId) {
        goodsMapper.deleteGood(goodId);
    }
}
