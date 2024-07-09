package com.dai.controller;

import com.dai.model.User;
import com.dai.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author daihongli
 * @version 1.0
 * @ClassName UserController
 * @Description: TODO
 * @Date 2024-07-08 20:56
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/show")
    public String show() {
        System.out.println("UserController ......");
        userService.show();
        return "/index.html";
    }

    @GetMapping("/show1")
    public String show1(@RequestParam("username") String username, @RequestParam("age") int age) {
        System.out.println(username + ">>>>>>" + age);
        return "/index.jsp";
    }

    @GetMapping("/show2")
    public String show2(@RequestParam("birthday") @DateTimeFormat(pattern = "yyyy/MM/dd") Date birthday) {
        System.out.println(birthday);
        return "/index.jsp";
    }

    // http://localhost/spring_mvc_test4/show3?username=haohao&age=35&hobbies=eat&hobbies=sleep&birthday=1986/01/01&address.city=tianjin&address.area=jinghai
    @GetMapping("/show3")
    public String show3(User user) {
        System.out.println(user.getBirthday() + ">>>>>>" + user.getAddress().getCity());
        return "/index.jsp";
    }

    // http://localhost/spring_mvc_test4/show4?hobbies=aaa&hobbies=bbb
    @GetMapping("/show4")
    public String show4(@RequestParam("hobbies") List<String> hobbies) {
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        return "/index.jsp";
    }

    // http://localhost/spring_mvc_test4/show5?username=haohao&age=18
    @GetMapping("/show5")
    public String show5(@RequestParam Map<String, Object> params) {
        for (Object item : params.entrySet()) {
            System.out.println(item);
        }
        return "/index.jsp";
    }

    //GET http://localhost/spring_mvc_test4/show6
    //
    // {
    //  "username":"haohao",
    //  "age":18,
    //  "hobbies":["eat","sleep"],
    //  "birthday":"1986-01-01",
    //  "address":{
    //  "city":"tj",
    //  "area":"binhai"
    //  }
    // }
    @GetMapping("/show6")
    public String show6(@RequestBody String body) {
        System.out.println(body);
        return "/index.jsp";
    }

    // GET http://localhost/spring_mvc_test4/show7
    //
    // {
    //  "username":"haohao",
    //  "age":18,
    //  "hobbies":["eat","sleep"],
    //  "birthday":"1986-01-01",
    //  "address":{
    //  "city":"tj"
    //  }
    // }
    @PostMapping("/show7")
    public String show7(@RequestBody String body) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(body, User.class);
        System.out.println(user);
        return "/index.jsp";
    }

    // POST http://localhost/spring_mvc_test4/show8
    // Content-Type:application/json
    //
    // {
    //  "username":"haohao",
    //  "age":18,
    //  "hobbies":["eat","sleep"],
    //  "birthday":"1986-01-01",
    //  "address":{
    //  "city":"tj"
    //  }
    // }
    @PostMapping("/show8")
    public String show8(@RequestBody User user) {
        System.out.println(user);
        return "/index.jsp";
    }

    // POST http://localhost/spring_mvc_test4/show9
    // Content-Type:application/json
    //
    // {
    //  "username":"haohao",
    //  "age":18,
    //  "hobbies":["eat","sleep"],
    //  "birthday":"1986-01-01",
    //  "address":{
    //  "city":"tj"
    //  }
    // }
    @PostMapping("/show9")
    public String show9(@RequestBody Map map) {
        System.out.println(map);
        return "/index.jsp";
    }
}
