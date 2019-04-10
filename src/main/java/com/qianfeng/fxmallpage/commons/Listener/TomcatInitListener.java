package com.qianfeng.fxmallpage.commons.Listener;

import com.qianfeng.fxmallpage.commons.utils.ApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TomcatInitListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------服务器启动————");
        ApplicationContextUtils.info();
        System.out.println(ApplicationContextUtils.getApplicationContext());
        System.out.println("--------服务器启动————");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
