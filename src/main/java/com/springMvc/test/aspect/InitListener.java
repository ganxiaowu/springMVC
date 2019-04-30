package com.springMvc.test.aspect;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义监听器
 */
@Slf4j
public class InitListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("------------------------项目开始加载配置------------------------");
        //需要加载的配置文件



    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("------------------------容器销毁------------------------");
    }
}
