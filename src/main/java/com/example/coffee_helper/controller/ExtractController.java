package com.example.coffee_helper.controller;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.coffee_helper.config.auth.PrincipalDetails;
import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.ExtractMentDTO;
import com.example.coffee_helper.dto.ResponseResultExtractDTO;
import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.ExtractMent;
import com.example.coffee_helper.extractSoftware.ExtractSoftService;
import com.example.coffee_helper.service.ExtractFeedbackService;
import com.example.coffee_helper.service.ExtractFeedbackServiceImpl;
import com.example.coffee_helper.service.ExtractSerive;
import com.example.coffee_helper.service.member.user.UserServiceImpl;

@Controller
public class ExtractController {
    
    @Autowired
    ExtractSoftService extractSoftware;

    @Autowired
    ExtractFeedbackServiceImpl feedbackService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ExtractSerive extractSerive;


    
    @GetMapping("/machineExtract")
    public String machineExtract(@AuthenticationPrincipal PrincipalDetails principalUser,Model model,RedirectAttributes rab){
        ExtractDTO extract = extractSoftware.extractSoft();
        ResponseResultExtractDTO resultExtractDTO = feedbackService.feedbakMent(extract);

        rab.addFlashAttribute("resultExtractDTO", resultExtractDTO);
        // model.addAttribute("resultExtractDTO", resultExtractDTO);

        // try {
        //     UserDTO user = userService.nameToRole(principalUser.getUsername());
        //     model.addAttribute("user", user);
        // } catch (Exception e) {
            
        // }

        return "redirect:/";
    }
    
    @GetMapping("/machineExtract2")
    public @ResponseBody ResponseResultExtractDTO machinExtract2(){
        ExtractDTO extract = extractSoftware.extractSoft();
        ResponseResultExtractDTO resultExtractDTO = feedbackService.feedbakMent(extract);


        return resultExtractDTO;
    }


    @PostMapping("/extract/machineExtract")
    public @ResponseBody ResponseEntity  extractSave(@AuthenticationPrincipal PrincipalDetails principalUser, @RequestBody ResponseResultExtractDTO resultExtractDTO){
        System.out.println("컨트롤러진입" + resultExtractDTO);
        UserDTO userDTO=userService.findUserInfo(principalUser.getUsername());
        int result = extractSerive.extractResultSave(resultExtractDTO, userDTO.getIdx());

        if(result>0){
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user/extract")
    public String userExtract(ExtractDTO extractDTO, @AuthenticationPrincipal PrincipalDetails principalUser, Model model, RedirectAttributes rab){
        
        
        extractDTO.setUserId(principalUser.getUser().getIdx());
        ResponseResultExtractDTO resultExtractDTO=feedbackService.feedbakMent(extractDTO);
        rab.addFlashAttribute("resultExtractDTO", resultExtractDTO);
        // model.addAttribute("resultExtractDTO", resultExtractDTO);
        // UserDTO user=userService.nameToRole(principalUser.getUsername());
        // model.addAttribute("user",user);        

        return "redirect:/";
    }
    


}
