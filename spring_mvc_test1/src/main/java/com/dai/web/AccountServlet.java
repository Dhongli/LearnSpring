package com.dai.web;

import com.dai.config.ApplicationConfig;
import com.dai.service.AccountService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(urlPatterns = "/accountServlet")
public class AccountServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        // ApplicationContext app = (ApplicationContext) servletContext.getAttribute("applicationContext");
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transferMoney("tom", "lucy", 500);
    }


}
