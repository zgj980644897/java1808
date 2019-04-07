package com.qianfeng.fxmallpage.goods.Servlet;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodsServlet2{
    public void queryGoodByPage(HttpServletRequest req, HttpServletResponse resp) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring.xml");
        try {
            GoodsServlet servlet=applicationContext.getBean(GoodsServlet.class);
            servlet.queryGoodByPage(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
