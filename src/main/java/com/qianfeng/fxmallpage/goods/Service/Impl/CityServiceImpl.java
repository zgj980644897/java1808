package com.qianfeng.fxmallpage.goods.Service.Impl;

import com.qianfeng.fxmallpage.commons.info.SystemConstantsUitls;
import com.qianfeng.fxmallpage.goods.Service.ICityService;
import com.qianfeng.fxmallpage.goods.bean.City;
import com.qianfeng.fxmallpage.goods.dao.ICityDAO;
import com.qianfeng.fxmallpage.goods.dao.impl.CityDAOImpl;

import java.util.List;
import java.util.UUID;

public class CityServiceImpl implements ICityService {
    private ICityDAO dao= new CityDAOImpl();
    @Override
    public List<City> queryGoodByPage(Integer page) throws Exception {
        if (page < 1) {
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        Integer index=(page-1)* SystemConstantsUitls.Page.pageSize;
        List<City> cityList = dao.queryGoodByPage(index);
        return cityList;
    }

    @Override
    public void addCity(City city) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        String sub=s.substring(0,8);
        long l = Long.parseLong(sub);
        city.setCityId(l);
        dao.addCity(city);

    }

    @Override
    public void updateCity(City city) {
        dao.updateCity(city);
    }

    @Override
    public void deleteCity(Integer cityId) {
        dao.deleteCity(cityId);
    }
}
