package com.qianfeng.fxmallpage;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.commons.mybatis.MyBatisSessionFactoryUitls;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPage{
    @Test
    public void testpage() {
        GoodsMapper goodsMapper = MyBatisSessionFactoryUitls.getSession().getMapper(GoodsMapper.class);
        System.out.println(goodsMapper);
        List<WxbGood> goods = goodsMapper.queryGoodByPage(1, SystemConstantsUitls.Page.pageSize);
        System.out.println(goods);
    }
    @Test
    public void test1(int i,int j){
        i=i+j;
        System.out.println(i+" ");
        j=j+i;
        System.out.println(j+" ");
        test1(i,j);
    }
    @Test
    public void aa(){
        test1(1,1);
    }
}
