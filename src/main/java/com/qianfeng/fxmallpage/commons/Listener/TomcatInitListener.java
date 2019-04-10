package com.qianfeng.fxmallpage.commons.Listener;

import com.qianfeng.fxmallpage.commons.utils.ApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TomcatInitListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------服务器启动————");
        ApplicationContextUtils.info();
        System.out.println(ApplicationContextUtils.getApplicationContext());
        System.out.println("--------服务器启动————");
    }


    public void contextDestroyed(ServletContextEvent sce) {

    }
}
