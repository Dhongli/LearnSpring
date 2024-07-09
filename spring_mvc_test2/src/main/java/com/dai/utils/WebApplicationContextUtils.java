package com.dai.utils;

import jakarta.servlet.ServletContext;
import org.springframework.context.ApplicationContext;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName WebApplicationContextUtils
 * @Description: TODO
 * @Date 2024-07-04 21:52
 */
public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext) {
        return (ApplicationContext)servletContext.getAttribute("applicationContext");
    }
}
