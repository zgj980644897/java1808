package com.qianfeng.fxmallpage.goods.Servlet;

import com.qianfeng.fxmallpage.commons.utils.ApplicationContextUtils;
import com.qianfeng.fxmallpage.goods.Service.IGoodsService;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;

public class GoodsServlet extends BaseServlet {

    private  IGoodsService goodsService;



    public void queryGoodByPage(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        String page=req.getParameter("page");
        goodsService= (IGoodsService) ApplicationContextUtils.getApplicationContext().getBean("goodsServiceImpl");
        try {
            String pageStr=page==null?"1":page;

            System.out.println("++++++"+goodsService);
            Method[] methods = goodsService.getClass().getMethods();
            for (Method m:methods){
                System.out.println(m.getName()+m.toString());
            }
            List<WxbGood> goods=goodsService.queryGoodByPage(Integer.parseInt(pageStr));

            System.out.println("---------"+goods);
            req.setAttribute("goods",goods);
            req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addGood(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
       /* good_id, good_name,customer_id,good_pic,good_pic1,good_pic2,promote_desc,sku_title,sku_cost,
        sku_price,sku_pmoney,copy_ids,copy_desc,forward_link,order_no,type_id,tags,state,create_time,
        toped,recomed,toped_time,recomed_time,spc_id,zon_id,sell_num,website,iswxpay,
        isfdfk,leixing_id,kfqq*/

        /*获取表单传输的值*/
        String goodId = req.getParameter("goodId");
        if (goodId != null) {
            goodsService = (IGoodsService) ApplicationContextUtils.getApplicationContext().getBean("goodsServiceImpl");
            WxbGood good = goodsService.queryGoodById(goodId);
            req.getSession().setAttribute("good", good);
            System.out.println(good);
            req.getRequestDispatcher("good_add.jsp").forward(req, resp);
        } else {
            String good_name = req.getParameter("good_name");
            String customer_id = req.getParameter("customer_id");
            String good_pic = req.getParameter("good_pic");
            String good_pic1 = req.getParameter("good_pic1");
            String good_pic2 = req.getParameter("good_pic2");
            String promote_desc = req.getParameter("promote_desc");
            String sku_title = req.getParameter("sku_title");
            String sku_cost = req.getParameter("sku_cost");
            String sku_price = req.getParameter("sku_price");
            String sku_pmoney = req.getParameter("sku_pmoney");
            String copy_ids = req.getParameter("copy_ids");
            String copy_desc = req.getParameter("copy_desc");
            String forward_link = req.getParameter("forward_link");
            String order_no1 = req.getParameter("order_no");
            Long order_no = 0L;
            if (order_no != null) {
                order_no = Long.parseLong(order_no1);
            }
            String type_id = req.getParameter("type_id");
            String tags = req.getParameter("tags");
            String state1 = req.getParameter("state");
            Long state = 0L;
            if (state1 != null) {
                state = Long.parseLong(state1);
            }
            String create_time1 = req.getParameter("create_time");
            Timestamp create_time = null;
            if (create_time1 != null) {
                create_time = Timestamp.valueOf(create_time1);
            }
            String toped1 = req.getParameter("toped");
            Long toped = 0L;
            if (toped1 != null) {
                toped = Long.parseLong(toped1);
            }
            String recomed1 = req.getParameter("recomed");
            Long recomed = 0L;
            if (recomed1 != null) {
                recomed = Long.parseLong(recomed1);
            }
            String toped_time1 = req.getParameter("toped_time");
            Timestamp toped_time = null;
            if (toped_time1 != null) {
                toped_time = Timestamp.valueOf(toped_time1);
            }
            String recomed_time1 = req.getParameter("recomed_time");
            Timestamp recomed_time = null;
            if (recomed_time1 != null) {
                recomed_time = Timestamp.valueOf(recomed_time1);
            }
            String spc_id = req.getParameter("spc_id");
            String zon_id = req.getParameter("zon_id");
            String sell_num1 = req.getParameter("sell_num");
            Long sell_num = 0L;
            if (sell_num1 != null) {
                sell_num = Long.parseLong(sell_num1);
            }
            String website = req.getParameter("website");
            String iswxpay1 = req.getParameter("iswxpay");
            Long iswxpay = 0L;
            if (iswxpay1 != null) {
                iswxpay = Long.parseLong(iswxpay1);
            }
            String isfdfk1 = req.getParameter("isfdfk");
            Long isfdfk = 0L;
            if (isfdfk1 != null) {
                isfdfk = Long.parseLong(isfdfk1);
            }
            String leixing_id1 = req.getParameter("leixing_id");
            Long leixing_id = 0L;
            if (leixing_id1 != null) {
                leixing_id = Long.parseLong(leixing_id1);
            }
            String kfqq = req.getParameter("kfqq");
            /*新建WxbGood类*/
            WxbGood wxbGood = new WxbGood("-1", good_name, customer_id, good_pic, good_pic1, good_pic2, promote_desc, sku_title, sku_cost,
                    sku_price, sku_pmoney, copy_ids, copy_desc, forward_link, order_no, type_id, tags, state, create_time,
                    toped, recomed, toped_time, recomed_time, spc_id, zon_id, sell_num, website, iswxpay,
                    isfdfk, leixing_id, kfqq);
            /*添加进数据库*/
            goodsService.addGood(wxbGood);

        }
    }

}
