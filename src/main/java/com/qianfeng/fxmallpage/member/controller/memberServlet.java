package com.qianfeng.fxmallpage.member.controller;

import com.qianfeng.fxmallpage.member.VO.JsonVO;
import com.qianfeng.fxmallpage.member.VO.MemberVO;

import com.qianfeng.fxmallpage.member.bean.WxbMemeber;
import com.qianfeng.fxmallpage.member.exception.PasswordErrorException;
import com.qianfeng.fxmallpage.member.exception.UserNotFoundException;
import com.qianfeng.fxmallpage.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class memberServlet {
    @Autowired
    private IMemberService memberService;
    @ResponseBody
    @RequestMapping("/memberlogin")
    public JsonVO login(MemberVO member, HttpSession session){
        JsonVO jsonVO = new JsonVO();
        try {
            WxbMemeber wxbMemeber = memberService.memberLogin(member);
            session.setAttribute("wxbMember",wxbMemeber);
            jsonVO.setCode(1);
        } catch (NullPointerException e) {
            e.printStackTrace();
            jsonVO.setCode(0);
            jsonVO.setMsg("请输入用户名");
        } catch (PasswordErrorException | UserNotFoundException e){
            e.printStackTrace();
            jsonVO.setCode(0);
            jsonVO.setMsg("用户名或密码错误");
        } catch (Exception e){
            e.printStackTrace();
            jsonVO.setCode(0);
            jsonVO.setMsg("请联系管理员");
        }
        return jsonVO;
    }
}
