package com.qianfeng.fxmallpage.goods.Service.Impl;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.goods.Service.IGoodsService;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.dao.IGoodsDAO;
import com.qianfeng.fxmallpage.goods.dao.impl.GoodsDAOImpl;

import java.util.List;

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
}
