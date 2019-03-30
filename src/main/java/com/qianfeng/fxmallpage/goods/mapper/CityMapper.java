package com.qianfeng.fxmallpage.goods.mapper;

import com.qianfeng.fxmallpage.goods.bean.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {
    /* 按id查找城市*/
    List<City> queryCityByPage (@Param("index") Integer index,@Param("size") Integer size);
    /*添加城市*/
    void addCity(@Param("city") City city);
    /*修改城市*/
    void updateCity(@Param("city") City city);
    /*根据id删除城市*/
    void deleteCity(@Param("cityId") Integer cityId);
}
