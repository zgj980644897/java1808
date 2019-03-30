package com.qianfeng.fxmallpage.goods.dao;

import com.qianfeng.fxmallpage.goods.bean.WxbGood;

import java.util.List;

public interface IGoodsDAO {
    /**
     * 分页查询
     * @param page
     * @return
     * @throws Exception
     */
    List<WxbGood> queryGoodByPage(Integer page) throws Exception;

    /**
     * 添加商品
     * @param good
     */
    void addGood(WxbGood good);

    /**
     * 修改商品
     * @param good
     */
    void updateGood(WxbGood good);

    /**
     * 根据id删除商品
     * @param goodId
     */
    void deleteGood(Integer goodId);
}
