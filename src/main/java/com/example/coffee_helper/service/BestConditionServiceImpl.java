package com.example.coffee_helper.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.dto.SettingConditionDTO;
import com.example.coffee_helper.entity.BestCondition;
import com.example.coffee_helper.entity.SettingCondition;
import com.example.coffee_helper.mapper.condition.BestConditionMapper;

@Service
public class BestConditionServiceImpl implements BestConditionService {

    @Autowired
    BestConditionMapper conditionMapper;

    ModelMapper modelMapper = new ModelMapper();


    
    @Override
    public List<BestConditionDTO> findAllCondition() {
        Boolean check = checkSetting();
        if(check){
            System.out.println("셋팅컨디션적용");
            return findSettingCondition();
        }
        System.out.println("기본컨디션적용");
        return findDefaultCondition();
    }

    //현재 설정되어있는 세팅체크하기
    @Override
    public Boolean checkSetting(){

        return conditionMapper.checkSetting();
    }
    //셋팅값 변경을 위한 0(false)면 기본값 1(true)면 셋팅값
    @Override
    public int settingChange(Boolean check) {
        
        return conditionMapper.settingChange(check);
    }

    @Override
    public List<BestConditionDTO> findDefaultCondition() {
        List<BestCondition> conditionsbefore = conditionMapper.findAllDefaultCondition();
        // System.out.println("기본컨디션적용");
        List<BestConditionDTO> conditions = conditionsbefore.stream()
        .map(BestCondition->modelMapper.map(BestCondition, BestConditionDTO.class))
        .collect(Collectors.toList());
        return conditions;
    }

    @Override
    public List<BestConditionDTO> findSettingCondition() {
        List<BestCondition> conditionsbefore = conditionMapper.findSettingCondition();
        // System.out.println("셋팅컨디션적용");
        List<BestConditionDTO> conditions = conditionsbefore.stream()
        .map(BestCondition->modelMapper.map(BestCondition, BestConditionDTO.class))
        .collect(Collectors.toList());
        return conditions;
    }

    @Override
    public void settingOptionChang(SettingConditionDTO settingConditionDTO) {
        SettingCondition settingCondition = modelMapper.map(settingConditionDTO, SettingCondition.class);
        
        conditionMapper.settingOptionChang(settingCondition);
        
        return;
    };
    
    
        // @Override
        // public List<BestConditionDTO> findAllCondition2() {
        //     return conditionMapper.findAllDefaultCondition().stream()
        //     .map(BestCondition->modelMapper.map(BestCondition, BestConditionDTO.class))
        //     .collect(Collectors.toList());
        // }
    

}
