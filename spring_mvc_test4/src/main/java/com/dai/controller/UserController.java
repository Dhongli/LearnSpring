package com.dai.controller;

import com.dai.model.User;
import com.dai.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

    // GET http://localhost/spring_mvc_test4/show6
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

    @PostMapping("/user/{id}")
    public String show9(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "/index.jsp";
    }


    @PostMapping("/fileUpload")
    public String fileUpload(@RequestParam("myFile") MultipartFile myFile) throws IOException {
        System.out.println(myFile);
        // 获得上传的文件的流对象
        InputStream inputStream = myFile.getInputStream();
        FileOutputStream outputStream = new
                FileOutputStream("F:\\" + myFile.getOriginalFilename());
        IOUtils.copy(inputStream, outputStream);
        // 关闭资源
        inputStream.close();
        outputStream.close();
        return "/index.jsp";
    }

    // 接收Http请求头数据，接收指定名称的请求头
    @GetMapping("/headers")
    public String headers(@RequestHeader("Accept-Encoding") String acceptEncoding){
        System.out.println("Accept-Encoding:"+acceptEncoding);
        return "/index.jsp";
    }

    // 接收所有的请求头信息
    @GetMapping("/headersMap")
    public String headersMap(@RequestHeader Map<String,String> map){
        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
        return "/index.jsp";
    }

    // 获得客户端携带的Cookie数据
    @GetMapping("/cookies")
    public String cookies(@CookieValue(value = "JSESSIONID",defaultValue = "") String jsessionid){
        System.out.println(jsessionid);
        return "/index.jsp";
    }

    // 获得转发Request域中数据，在进行资源之间转发时，有时需要将一些参数存储到request域中携带给下一个资源
    @GetMapping("/request1")
    public String request1(HttpServletRequest request){
        //存储数据
        request.setAttribute("username","阿道夫");
        return "forward:/request2";
    }
    @GetMapping("/request2")
    public String request2(@RequestAttribute("username") String username){
        System.out.println(username);
        return "/index.jsp";
    }
}
