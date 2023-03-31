package com.example.coffee_helper.controller.member;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coffee_helper.dto.ExtractEqualsInfoDTO;
import com.example.coffee_helper.dto.ExtractMentDTO;
import com.example.coffee_helper.extractSoftware.ExtractEqualsInfoService;
import com.example.coffee_helper.service.ExtractMentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AdminController {
    
    @Autowired
    ExtractEqualsInfoService extractEqualsInfoService;

    @Autowired
    ExtractMentService mentService;
    
    //관리자 홈
    @GetMapping("/admin")
    public String adminHome(){
        
        
        return "admin/adminHome";
    }

    //멘트별 조건마다 자동으로 번호 매겨주는 소프트웨어 실행요청 (1번씩만 사용)
    @GetMapping("/designateMentNum")
    public String designateMentNum(){
        extractEqualsInfoService.designateMentNum();
        
        return "admin/adminHome";
    }

    //추출별멘트 등록이동요청
    @GetMapping("/admin/extractMent")
    public String extractMent(){
            
        
        return "admin/extractMent";
    }
    //추출별멘트 등록요청
    @PostMapping("/admin/extractMent")
    public String insertMent(ExtractEqualsInfoDTO equalsDTO, @RequestParam("ment")String ment, RedirectAttributes rab){
        int result=mentService.insertMent(equalsDTO, ment);
        if(result<0){
            rab.addFlashAttribute("resultMessage", "재요청 바람");
            return "redirect:/admin/extractMent";
        }
        rab.addFlashAttribute("resultMessage", "성공");
        return "redirect:/admin";
    }
    //추출별멘트 삭제 요청
    @DeleteMapping("/admin/extractMent")
    public String deleteMent(){

        return "redirect:/admin";
    }
    
    


}
