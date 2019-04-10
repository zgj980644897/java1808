package com.qianfeng.fxmallpage.goods.Servlet;

import com.qianfeng.fxmallpage.commons.utils.ApplicationContextUtils;
import com.qianfeng.fxmallpage.goods.Service.ILoginService;
import com.qianfeng.fxmallpage.goods.bean.UserInfo;
import com.qianfeng.fxmallpage.goods.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Retention;

@Controller
public class Login {

    ILoginService loginService;
    @RequestMapping("/login")
    public String login(UserInfo userInfo, Model model) {
        loginService = (ILoginService) ApplicationContextUtils.getApplicationContext().getBean("loginServiceImpl");
        try {
            UserInfo user = loginService.login(userInfo.getUserName(), userInfo.getPassword());
            if (user != null) {
                model.addAttribute("user", user);
                return ("goods_list.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "账号或密码错误");
            System.out.println("账号或密码错误");
            return ("goods_list.jsp");
        }
        return ("goods_list.jsp");

    }
}
