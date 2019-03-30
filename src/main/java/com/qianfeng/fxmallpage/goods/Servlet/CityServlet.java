package com.qianfeng.fxmallpage.goods.Servlet;

import com.qianfeng.fxmallpage.goods.Service.ICityService;
import com.qianfeng.fxmallpage.goods.Service.Impl.CityServiceImpl;
import com.qianfeng.fxmallpage.goods.bean.City;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityServlet extends BaseServlet{
    private ICityService service=new CityServiceImpl();
    public void queryCityByPage(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        String page=req.getParameter("page");
        String index = page==null?"0":page;
        try {
            List<City> cityList = service.queryGoodByPage(Integer.parseInt(index));
            req.setAttribute("cityList",cityList);
            req.getRequestDispatcher("#").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
