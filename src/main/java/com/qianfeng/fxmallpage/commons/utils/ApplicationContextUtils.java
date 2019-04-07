package com.qianfeng.fxmallpage.commons.utils;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {
    private static ClassPathXmlApplicationContext applicationContext;
    public static void info(){
        applicationContext=new ClassPathXmlApplicationContext("spring/spring.xml");
    }

    public static ClassPathXmlApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
