package com.qianfeng.fxmallpage.goods.Service;

import com.qianfeng.fxmallpage.goods.bean.UserInfo;

public interface ILoginService {
    UserInfo login(String username, String password) throws Exception;
}
