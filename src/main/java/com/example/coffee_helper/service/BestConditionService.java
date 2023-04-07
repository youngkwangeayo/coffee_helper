package com.example.coffee_helper.service;

import java.util.List;
import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.dto.SettingConditionDTO;
import com.example.coffee_helper.entity.BestCondition;



public interface BestConditionService {
    
    //현재추출비교셋팅값 
    List<BestConditionDTO> findAllCondition();
    
    //기본추출비교셋팅값 
    List<BestConditionDTO> findDefaultCondition();
    
    //설정된추출비교셋팅값
    List<BestConditionDTO> findSettingCondition();
    
    //셋팅 변경스위치
    int settingChange(Boolean check);
    
    //현재 어떤 셋팅값을 사용하느지 체크
    Boolean checkSetting();
    
    //셋팅값 바꾸기
    void settingOptionChang(SettingConditionDTO settingConditionDTO);
}
