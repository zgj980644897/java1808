package com.qianfeng.fxmallpage.goods.mapper;

import com.qianfeng.fxmallpage.goods.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    UserInfo login(@Param("username") String username);
}
