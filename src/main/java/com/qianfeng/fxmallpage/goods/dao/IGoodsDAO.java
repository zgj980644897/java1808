package com.qianfeng.fxmallpage.goods.dao;

import com.qianfeng.fxmallpage.goods.bean.WxbGood;

import java.util.List;

public interface IGoodsDAO {
    List<WxbGood> queryGoodByPage(Integer page) throws Exception;
}
