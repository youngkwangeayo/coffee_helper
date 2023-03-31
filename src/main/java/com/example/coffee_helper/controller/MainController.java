package com.example.coffee_helper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coffee_helper.config.auth.PrincipalDetails;
import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.dto.ChartBestFiveDTO;
import com.example.coffee_helper.service.BestConditionService;
import com.example.coffee_helper.service.ChartService;
import com.example.coffee_helper.service.member.user.UserServiceImpl;
import com.example.coffee_helper.extractSoftware.ExtractSoftService;
import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.UserDTO;

@Controller
public class MainController {
    
    @Autowired
    BestConditionService cs;

    @Autowired
	ExtractSoftService soft;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ChartService chartService;

    //메인홈
    @GetMapping("/")
    public String mainHome(@AuthenticationPrincipal PrincipalDetails principalUser,Model model){
        
        try {
            List<ChartBestFiveDTO>bestFiveDTO=chartService.chartBestFive();
            model.addAttribute("bestFiveDTO", bestFiveDTO);
        } catch (Exception e) {
        
        }

        try {
            UserDTO user = userService.nameToRole(principalUser.getUsername());
            model.addAttribute("user", user);
        } catch (Exception e) {
            return "home";

        }
        return "home";
    }


    @GetMapping("/layout")
    public String layoutTest(){

        return "layout/defaultLayout";
    }

    @GetMapping("/s")
    public String s(){
        
        for(int i=0; i<15; i++){
            ExtractDTO d =  soft.extractSoft();
            System.out.println(d.toString());
        }

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
