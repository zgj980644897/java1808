package com.qianfeng.fxmallpage.goods.Service;

import com.qianfeng.fxmallpage.goods.bean.WxbGood;

import java.util.List;

public interface IGoodsService {
    List<WxbGood> queryGoodByPage (Integer page) throws Exception;
    /**
     * 根据id查找商品
     * @param goodId
     * @return
     */
    WxbGood queryGoodById(String goodId);
    /**
     * 添加商品
     * @param good
     */
    void addGood(WxbGood good);

    /**
     * 修改商品
     * @param good
     */
    void update(WxbGood good);

    /**
     * 根据id删除商品
     * @param goodId
     */
    void delect(Integer goodId);
}
