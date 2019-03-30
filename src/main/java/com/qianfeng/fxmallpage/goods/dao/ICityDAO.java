package com.qianfeng.fxmallpage.goods.dao;

import com.qianfeng.fxmallpage.goods.bean.City;

import java.util.List;

public interface ICityDAO {
    /**
     * 分页查询
     * @param page
     * @return
     * @throws Exception
     */
    List<City> queryGoodByPage(Integer page) throws Exception;

    /**
     * 添加城市
     * @param
     */
    void addCity(City city);

    /**
     * 修改城市
     * @param
     */
    void updateCity(City city);

    /**
     * 根据id删除城市
     * @param
     */
    void deleteCity(Integer cityId);
}
