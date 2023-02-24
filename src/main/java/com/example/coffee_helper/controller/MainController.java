package com.example.coffee_helper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    
    //메인홈
    @GetMapping("/")
    public String mainHome(){

        return "home";
    }


    @GetMapping("/layout")
    public String layoutTest(){

        return "layout/defaultLayout";
    }

    @GetMapping("/s")
    public String s(){

        return "yk/deheader";
    }
}
