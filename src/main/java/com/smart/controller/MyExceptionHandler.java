package com.smart.controller;

import com.smart.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(value = {UserNotExistException.class})
//    public Map<String,Object> handleUserNotExistException(Exception ex){
          /**
           * 这种方法无法自适应，无论是浏览器还是客户端访问，都是返回json数据
           */
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notExist");
//        map.put("message",ex.getMessage());
//        return map;
//    }

    @ExceptionHandler(value = {UserNotExistException.class})
    public String handleUserNotExistException(Exception ex, HttpServletRequest request){
        /**
         * 这种做法能自适应，使浏览器返回error页面，客户端返回json数据，但是不能解析状态码，并为200
         * 解决办法：在request域中添加属性"javax.servlet.error.status_code"
         * 但是只是这样还是不能在json中返回自己定制的信息，
         * 需要编写一个ErrorAttributes类（可以继承DefaultErrorAttributes类），重写getErrorAttributes()方法
         */
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notExist");
        map.put("message",ex.getMessage());
        // 在自己编写的ErrorAttributes类中取出
        request.setAttribute("ext",map);
        return "forward:/error";
    }
}
