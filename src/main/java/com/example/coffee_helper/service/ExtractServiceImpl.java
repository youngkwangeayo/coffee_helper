package com.example.coffee_helper.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.ExtractMentDTO;
import com.example.coffee_helper.dto.ExtractResultMentDTO;
import com.example.coffee_helper.dto.ResponseResultExtractDTO;
import com.example.coffee_helper.dto.UserDTO;
import com.example.coffee_helper.entity.Extract;
import com.example.coffee_helper.entity.ExtractResultMent;
import com.example.coffee_helper.mapper.ExtractMapper;

@Service
public class ExtractServiceImpl implements ExtractSerive {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    ExtractMapper extractMapper;




    //익스트렉트 정보 저장
    @Override
    public int extractSave(ExtractDTO extractDTO,int userId) {
        extractDTO.setUserId(userId);
        Extract extract = modelMapper.map(extractDTO, Extract.class);
        int result=extractMapper.saveMachineExtract(extract);
        if(result<0){
            return -1;
        }
        
        return extract.getId();
    }


    //익스트렉트결과저장
    @Override
    public int extractResultSave(ResponseResultExtractDTO resultExtractDTO,int userIdx) {
        int result =0;

        int extractId = extractSave(resultExtractDTO.getExtract(), userIdx);

        for(ExtractMentDTO mentDTO : resultExtractDTO.getMents()){
            ExtractResultMentDTO saveResultMentDTO = ExtractResultMentDTO.builder()
                .extractId(extractId)
                .mentId(mentDTO.getId()).build();
                
            result=saveExtractResultMent(saveResultMentDTO);
        }
       
        
        return result;
    }

    //추출에 대한 정보 저장
    @Override
    public int saveExtractResultMent(ExtractResultMentDTO saveResultMentDTO) {
        ExtractResultMent saveResultMent = modelMapper.map(saveResultMentDTO, ExtractResultMent.class);
        return extractMapper.saveExtractResultMent(saveResultMent);
        
    }


    @Override
    public int putCoffeeMemo(ExtractDTO extractDTO) {
        Extract extract = toEntity(extractDTO);
        int result = extractMapper.putCoffeeMemo(extract);

        return result;
    }
    
    private Extract toEntity(ExtractDTO dto){
        Extract e = modelMapper.map(dto, Extract.class);

        return e;
    }

    //-1이면 멘트 삭제 오류 -2면 추출삭제오류
    @Override
    public int deleteExtractAndSaveMent(int extractId) {
        int result =0;
        result = extractMapper.deleteSaveMentToId(extractId);
        if(result<0){
            return -1;
        }
        result = extractMapper.deleteExtractToId(extractId);
        if(result<0){
            return -2;
        }

        return result;
    }

}


