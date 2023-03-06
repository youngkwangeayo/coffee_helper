package com.example.coffee_helper.service;

import java.util.List;
import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.entity.BestCondition;



public interface BestConditionService {
    
    
    List<BestConditionDTO> findAllCondition();
    
    
}
