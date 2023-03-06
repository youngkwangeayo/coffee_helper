package com.example.coffee_helper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.service.BestConditionService;

@Controller
public class MainController {
    
    @Autowired
    BestConditionService cs;

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

    public int tq(){

       

        List<BestConditionDTO> dtos = cs.findAllCondition();
        if(dtos.isEmpty()){
            return 0;
        }

        return 1;
    }
}
