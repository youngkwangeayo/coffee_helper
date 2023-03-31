package com.example.coffee_helper.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.ExtractEqualsInfoDTO;
import com.example.coffee_helper.dto.ExtractMentDTO;
import com.example.coffee_helper.entity.ExtractEqualsInfo;
import com.example.coffee_helper.entity.ExtractMent;
import com.example.coffee_helper.mapper.ExtractEqualsInfoMapper;
import com.example.coffee_helper.mapper.ExtractMentMapper;

@Service
public class ExtractMentServiceimpl implements ExtractMentService {

    @Autowired
    ExtractEqualsInfoMapper equalsInfoMapper;

    @Autowired
    ExtractMentMapper mentMapper;

    
    ModelMapper modelMapper = new ModelMapper();

    //관리자가 멘트 집어 넣기
    @Override
    public int insertMent(ExtractEqualsInfoDTO equalsInfoDTO, String ment) {
        int equalsInfoId=findEqaulsId(equalsInfoDTO);
        int result=mentMapper.insertMent(equalsInfoId, ment);

        return result;
    }

    //멘트집어넣기 위해 추출 정보의 비교 아이디를 가져옴
    @Override
    public int findEqaulsId(ExtractEqualsInfoDTO equalsInfoDTO) {
        ExtractEqualsInfo equalsInfo = modelMapper.map(equalsInfoDTO, ExtractEqualsInfo.class);
        int equalsInfoId = equalsInfoMapper.findEqaulsId(equalsInfo);
        

        return equalsInfoId;
    }

    //고유 아이디로 추출의 결과 멘트 가져오기
    @Override
    public List<ExtractMentDTO> findMents(int eqaulsId) {
        // List<ExtractMent>ments=mentMapper.findMents(eqaulsId);

        return mentMapper.findMents(eqaulsId).stream()
        .map(ExtractMent->modelMapper.map(ExtractMent, ExtractMentDTO.class))
        .collect(Collectors.toList());
    }
    
    
}
// 익스트렉트 인터페이스랑 멘트인터페이스를 만들고 익스트렐트 리졸트세이브 서비스를 만들어 상속받게하고 하나로 관리??