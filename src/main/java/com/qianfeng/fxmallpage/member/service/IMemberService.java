package com.qianfeng.fxmallpage.member.service;

import com.qianfeng.fxmallpage.member.VO.MemberVO;
import com.qianfeng.fxmallpage.member.bean.WxbMemeber;
import com.qianfeng.fxmallpage.member.exception.UserNotFoundException;

public interface IMemberService {
    WxbMemeber memberLogin(MemberVO memberVO) throws UserNotFoundException, Exception;
}
