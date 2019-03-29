package com.qianfeng.fxmallpage.goods.mapper;

import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper2 {
    List<WxbGood>  queryGoodsByPage(@Param("index") Integer index,@Param("size") Integer size);
}
