package com.example.coffee_helper.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RequestMapping("/error")
@SuppressWarnings("deprecation")
public class CustomErrorController implements ErrorController{
    
    @RequestMapping(value="/error")
    public String  handleNoHandlerFoundException(HttpServletResponse response, HttpServletRequest request){ 
        return "error";
    }
}
