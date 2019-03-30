package com.qianfeng.fxmallpage.goods.dao.impl;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.commons.mybatis.MyBatisSessionFactoryUitls;
import com.qianfeng.fxmallpage.goods.bean.City;
import com.qianfeng.fxmallpage.goods.dao.ICityDAO;
import com.qianfeng.fxmallpage.goods.mapper.CityMapper;

import java.util.List;

public class CityDAOImpl implements ICityDAO {
    @Override
    public List<City> queryGoodByPage(Integer page) throws Exception {
        CityMapper mapper = MyBatisSessionFactoryUitls.getSession().getMapper(CityMapper.class);
        List<City> cityList = mapper.queryCityByPage(page, SystemConstantsUitls.Page.pageSize);
        return cityList;
    }

    @Override
    public void addCity(City city) {
        CityMapper mapper = MyBatisSessionFactoryUitls.getSession().getMapper(CityMapper.class);
        mapper.addCity(city);
        MyBatisSessionFactoryUitls.getSession().commit();
    }

    @Override
    public void updateCity(City city) {
        CityMapper mapper = MyBatisSessionFactoryUitls.getSession().getMapper(CityMapper.class);
        mapper.updateCity(city);
        MyBatisSessionFactoryUitls.getSession().commit();
    }

    @Override
    public void deleteCity(Integer cityId) {
        CityMapper mapper = MyBatisSessionFactoryUitls.getSession().getMapper(CityMapper.class);
        mapper.deleteCity(cityId);
        MyBatisSessionFactoryUitls.getSession().commit();
    }
}
