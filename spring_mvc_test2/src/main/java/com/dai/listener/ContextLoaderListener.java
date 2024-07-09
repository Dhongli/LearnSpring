package com.dai.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName ContextLoaderListener
 * @Description: TODO
 * @Date 2024-07-04 21:26
 */
public class ContextLoaderListener implements ServletContextListener {
    private static final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener init ......");
        ServletContext servletContext = sce.getServletContext();
        // 1. 获取contextConfigLocation配置文件
        String contextConfigLocation = servletContext.getInitParameter(CONTEXT_CONFIG_LOCATION);
        // 解析出配置文件名称(Demo简化，实际解析比这复杂)
        contextConfigLocation = contextConfigLocation.substring("classpath:".length());
        // 2. 创建Spring容器
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        // 3. 将容器存储到servletContext
        servletContext.setAttribute("applicationContext", app);
    }
}
