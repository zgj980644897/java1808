package com.qianfeng.fxmallpage;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.commons.mybatis.MyBatisSessionFactoryUitls;
import com.qianfeng.fxmallpage.goods.Service.IGoodsService;
import com.qianfeng.fxmallpage.goods.Service.Impl.GoodsServiceImpl;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;
import com.qianfeng.fxmallpage.goods.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;

public class TestPage{
    /*
    * 路人a提交的代码
    * */
/* 路人b提交了一行代码*/
    /*路人c提交了一行文艺的注释*/
    /*路人d提交了一行代码*/
    @Test
    public void testpage() {
        GoodsMapper goodsMapper = MyBatisSessionFactoryUitls.getSession().getMapper(GoodsMapper.class);
        System.out.println(goodsMapper);
        List<WxbGood> goods = goodsMapper.queryGoodByPage(1, SystemConstantsUitls.Page.pageSize);
        System.out.println(goods);
        /*路人甲提交了一行代码*/
        /*路人乙提交了代码*/
        /*路人e提交了代码*/
    }
    @Test
    public void testAdd(){
        IGoodsService service=new GoodsServiceImpl();
        Timestamp time=new Timestamp(2016-05-21193017);
        WxbGood good=new WxbGood("-1", "asdad", "69609206", "imageFolder/20160521/14886110_1.png", "imageFolder/20160521/14886110_2.png", "imageFolder/20160521/14886110_3.png", "adsads", "11|", "1|", "1|", "1|", "1887427", "", "", 11, "01", "1", 0, time, 0, 0, null, null, "","", 1, null, 0, 0, 0, null);
        service.addGood(good);
    }

}
