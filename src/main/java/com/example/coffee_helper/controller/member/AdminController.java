package com.example.coffee_helper.controller.member;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.dto.ExtractEqualsInfoDTO;
import com.example.coffee_helper.dto.ExtractMentDTO;
import com.example.coffee_helper.dto.SettingConditionDTO;
import com.example.coffee_helper.extractSoftware.ExtractEqualsInfoService;
import com.example.coffee_helper.service.BestConditionService;
import com.example.coffee_helper.service.ExtractMentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AdminController {
    
    @Autowired
    ExtractEqualsInfoService extractEqualsInfoService;

    @Autowired
    ExtractMentService mentService;

    @Autowired
    BestConditionService conditionService;
    
    //관리자 홈
    @GetMapping("/admin")
    public String adminHome(Model model){
        List<BestConditionDTO> defaultConditions =conditionService.findDefaultCondition();
        model.addAttribute("defaultConditions", defaultConditions);

        List<BestConditionDTO> settingConditions =conditionService.findSettingCondition();
        model.addAttribute("settingConditions", settingConditions);
        
        Boolean checkSetting=conditionService.checkSetting();
        model.addAttribute("checkSetting", checkSetting);

        return "admin/adminHome";
    }

    //멘트별 조건마다 자동으로 번호 매겨주는 소프트웨어 실행요청 (1번씩만 사용)
    @GetMapping("admin/designateMentNum")
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
    
    //셋팅옵션 진입
    @GetMapping("/admin/settingOption")
    public String settingOption(){
        
        return "admin/settingOption";
    }
    
    @PutMapping("/admin/settingOption")
    public String settingOptionChang(SettingConditionDTO settingDTO, RedirectAttributes rab){
        conditionService.settingOptionChang(settingDTO);
        rab.addFlashAttribute("resultMessage","변경완료");
        return "redirect:/admin";
    }

    //셋팅값 스위치
    @GetMapping("/admin/setting")//스위치 붙히기
    public String SettingCheck(@PathParam("check") Boolean check, RedirectAttributes rab){
        int result =conditionService.settingChange(check);
        if(result>0){
            rab.addFlashAttribute("resultMessage", "변경성공");
            return "redirect:/admin";    
        }
        rab.addFlashAttribute("resultMessage", "변경실패");
        return "redirect:/admin";
    }



}
