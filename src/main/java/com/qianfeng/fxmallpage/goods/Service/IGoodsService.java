package com.qianfeng.fxmallpage.goods.Service;

import com.qianfeng.fxmallpage.goods.bean.WxbGood;

import java.util.List;

public interface IGoodsService {
    List<WxbGood> queryGoodByPage (Integer page) throws Exception;
}
