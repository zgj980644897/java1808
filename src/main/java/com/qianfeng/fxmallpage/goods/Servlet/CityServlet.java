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
    public void addCity (HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        /**
         * city_id, city_name, province_id, first_letter, is_hot, state
         */
        String city_id=req.getParameter("city_id");

        String city_name=req.getParameter("city_name");
        String province_id=req.getParameter("province_id");
        String first_letter=req.getParameter("first_letter");
        String is_hot1=req.getParameter("is_hot");
        Long is_hot=0L;
        if (is_hot1!=null){
            is_hot=Long.parseLong(is_hot1);
        }
        String state1=req.getParameter("state");
        Long state=0L;
        if (state1!=null){
            state=Long.parseLong(state1);
        }
        /*创建城市对象*/
        City city = new City(-1L, city_name, province_id, first_letter, is_hot, state);
        service.addCity(city);
    }
    public void updateCity (HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

    }

    public void deleteCity(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

    }

}
