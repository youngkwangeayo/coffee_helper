package com.example.coffee_helper.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.BestConditionDTO;

import com.example.coffee_helper.entity.BestCondition;
import com.example.coffee_helper.mapper.BestConditionMapper;

@Service
public class BestConditionServiceImpl implements BestConditionService {

    @Autowired
    BestConditionMapper conditionMapper;

    ModelMapper modelMapper = new ModelMapper();

    // @Override
    public List<BestConditionDTO> findAllCondition2() {
        return conditionMapper.findAllCondition().stream()
        .map(BestCondition->modelMapper.map(BestCondition, BestConditionDTO.class))
        .collect(Collectors.toList());
    }
    @Override
    public List<BestConditionDTO> findAllCondition() {
        List<BestCondition> conditionsbefore = conditionMapper.findAllCondition();

        List<BestConditionDTO> conditions = conditionsbefore.stream()
        .map(BestCondition->modelMapper.map(BestCondition, BestConditionDTO.class))
        .collect(Collectors.toList());

        return conditions;
    }

    
    
    
    
    




}
