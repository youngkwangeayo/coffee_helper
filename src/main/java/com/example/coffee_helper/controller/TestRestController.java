package com.example.coffee_helper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class TestRestController {
    
    @GetMapping("get")
    public ModelAndView testG(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("car", "car2");
        // mav.addObject("result",ResponseEntity.status(HttpStatus.OK).build());
        mav.setViewName("/restResult");
        return mav;
    }
    
    
}
