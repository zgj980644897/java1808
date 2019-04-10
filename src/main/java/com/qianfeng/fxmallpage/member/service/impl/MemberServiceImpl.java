package com.qianfeng.fxmallpage.member.service.impl;

import com.qianfeng.fxmallpage.commons.utils.MD5Utils;

import com.qianfeng.fxmallpage.member.VO.MemberVO;
import com.qianfeng.fxmallpage.member.bean.WxbMemeber;
import com.qianfeng.fxmallpage.member.exception.PasswordErrorException;
import com.qianfeng.fxmallpage.member.exception.UserNotFoundException;
import com.qianfeng.fxmallpage.member.mapper.MemberMapper;
import com.qianfeng.fxmallpage.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private MemberMapper memberMapper;


    @Override
    public WxbMemeber memberLogin(MemberVO memberVO) throws Exception {
        if (memberVO==null){
            throw new NullPointerException();
        }
        System.out.println("-------"+memberVO);
        System.out.println("+++++++++"+memberMapper);
        String account = memberVO.getAccount();
        String password = memberVO.getPassword();
        if (account==null||"".equals(account)){
            throw new NullPointerException();
        }
        WxbMemeber wxbMemeber = memberMapper.memberLogin(account);
        if (wxbMemeber==null){
            throw new UserNotFoundException();
        }
        String md5 = MD5Utils.md5(password, account);
        if (!md5.equals(password)){
            throw new PasswordErrorException();
        }
        return wxbMemeber;
    }
}
