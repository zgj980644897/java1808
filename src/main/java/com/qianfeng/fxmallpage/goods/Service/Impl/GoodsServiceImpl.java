package com.qianfeng.fxmallpage.goods.Service.Impl;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.goods.Service.IGoodsService;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.dao.IGoodsDAO;
import com.qianfeng.fxmallpage.goods.dao.impl.GoodsDAOImpl;

import java.util.List;
import java.util.UUID;

public class GoodsServiceImpl implements IGoodsService {
    private IGoodsDAO dao =new GoodsDAOImpl();
    @Override
    public List<WxbGood> queryGoodByPage(Integer page) throws Exception {
        if (page < 1) {
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        Integer index=(page-1)* SystemConstantsUitls.Page.pageSize;
        List<WxbGood> goodList= dao.queryGoodByPage(index);
        return goodList;
    }

    @Override
    public void addGood(WxbGood good) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String sub=s.substring(0,8);
        good.setGoodId(sub);
        dao.addGood(good);
    }

    @Override
    public void update(WxbGood good) {
        dao.updateGood(good);
    }

    @Override
    public void delect(Integer goodId) {
        dao.deleteGood(goodId);
    }
}
