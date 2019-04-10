package com.qianfeng.fxmallpage.goods.Service.Impl;

import com.qianfeng.fxmallpage.commons.utils.MD5Utils;
import com.qianfeng.fxmallpage.goods.Service.ILoginService;
import com.qianfeng.fxmallpage.goods.bean.UserInfo;
import com.qianfeng.fxmallpage.goods.mapper.LoginMapper;

public class LoginServiceImpl implements ILoginService {
    private LoginMapper loginMapper;
@Override
    public UserInfo login(String username,String password) throws Exception{
        System.out.println(username+"---"+password);
        if (username==null){
            throw new NullPointerException("用户名为空");
        }
        UserInfo user = loginMapper.login(username);
        System.out.println("用户:"+user.toString());
        if (user==null){
            throw new NullPointerException("用户不存在");
        }
        String userSelf = user.getSelf();
        String s = MD5Utils.md5(password, userSelf);
        if (!user.getPassword().equals(s)){
            throw new NullPointerException("密码错误");
        }
        System.out.println("用户2："+user.toString());
        return user;
    }
}
