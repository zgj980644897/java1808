package com.qianfeng.fxmallpage;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.commons.mybatis.MyBatisSessionFactoryUitls;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPage{
    /*
    * 路人a提交的代码
    * */
/* 路人b提交了一行代码*/
    @Test
    public void testpage() {
        /*路人b又提交了一行代码*/
        GoodsMapper goodsMapper = MyBatisSessionFactoryUitls.getSession().getMapper(GoodsMapper.class);
        System.out.println(goodsMapper);
        List<WxbGood> goods = goodsMapper.queryGoodByPage(1, SystemConstantsUitls.Page.pageSize);
        System.out.println(goods);
        /*路人甲提交了一行代码*/
    }

}
