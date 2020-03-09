package com.smart.controller;

import com.smart.dao.UserDao;
import com.smart.exception.UserNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users",userDao.getAllUsers());
        // classpath:/templates/success.html，thymeleaf自动渲染
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/world")
    public String world(@RequestParam("user") String user){
        if("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "hello world";
    }
}
