package com.qianfeng.fxmallpage.goods.Servlet;

import com.qianfeng.fxmallpage.goods.Service.IGoodsService;
import com.qianfeng.fxmallpage.goods.Service.Impl.GoodsServiceImpl;
import com.qianfeng.fxmallpage.goods.bean.WxbGood;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends HttpServlet {
    private IGoodsService goodsService=new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page=req.getParameter("page");
        try {
            String pageStr=page==null?"1":page;
            List<WxbGood> goods= goodsService.queryGoodByPage(Integer.parseInt(pageStr));
            req.setAttribute("goods",goods);
            req.getRequestDispatcher("goods_list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
