package com.example.coffee_helper.service;

import java.util.HashMap;

import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.ExtractResultMentDTO;
import com.example.coffee_helper.dto.ResponseResultExtractDTO;

public interface ExtractSerive {
    int extractSave(ExtractDTO extractDTO,int userId);

    // int extractInfoSave(HashMap<Object,Object>map,int userIdx);

    int saveExtractResultMent(ExtractResultMentDTO saveMentDTO);

    
    int extractResultSave(ResponseResultExtractDTO resultExtractDTO,int userIdx);

    int putCoffeeMemo(ExtractDTO extractDTO);

    int deleteExtractAndSaveMent(int extractId);
}
