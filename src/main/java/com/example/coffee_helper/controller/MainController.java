package com.example.coffee_helper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    

    @GetMapping("/")
    public String mainHome(){

        return "home";
    }
}
