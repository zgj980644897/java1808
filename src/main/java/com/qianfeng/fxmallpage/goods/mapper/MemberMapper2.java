package com.qianfeng.fxmallpage.goods.mapper;

import com.qianfeng.fxmallpage.goods.bean.WxbMemeber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper2 {
    WxbMemeber memberLogin( String account);
}
