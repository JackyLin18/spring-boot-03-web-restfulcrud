package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
//  @RequestMapping(value = "/user/login", method = RequestMethod.POST),可以使用@PostMapping()代替
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Map<String,Object> map,
                        HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("logon",username);
            return "redirect:/main.html";
        }
        map.put("errors","用户名密码不匹配");
        return "login";
    }
}
