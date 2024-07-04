package com.dai.listener;

import com.dai.config.ApplicationConfig;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener init......");
        // 创建spring容器
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        // ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 将容器存储到servletContext域中
        sce.getServletContext().setAttribute("applicationContext", app);
    }
}
