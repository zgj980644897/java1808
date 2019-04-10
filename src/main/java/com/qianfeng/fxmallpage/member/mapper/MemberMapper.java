package com.qianfeng.fxmallpage.member.mapper;


import com.qianfeng.fxmallpage.member.bean.WxbMemeber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MemberMapper {
    WxbMemeber memberLogin(@Param("account") String account);
}
