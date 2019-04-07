package com.qianfeng.fxmallpage.goods.mapper;

import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    /**
     * 分页查询
     * @param index
     * @param size
     * @return
     */
    List<WxbGood> queryGoodByPage(@Param("index") Integer index,@Param("size") Integer size);

    /**
     * 根据id查找商品
     * @param goodId
     * @return
     */
    WxbGood queryGoodById(@Param("goodId") String goodId);

    /**
     * 添加商品
     * @param good
     */
    void addGood(@Param("good") WxbGood good);

    /**
     * 修改商品
     * @param good
     */
    void updateGood(@Param("good") WxbGood good);

    /**
     * 删除商品
     * @param goodId
     */
    void deleteGood(@Param("goodId") Integer goodId);
}
