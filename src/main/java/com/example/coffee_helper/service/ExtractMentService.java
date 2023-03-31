package com.example.coffee_helper.service;

import java.util.List;

import com.example.coffee_helper.dto.ExtractEqualsInfoDTO;
import com.example.coffee_helper.dto.ExtractMentDTO;

public interface ExtractMentService {
    
    //관리자가 멘트저장 익스트렉트멘트테이블에 저장됨
    int insertMent(ExtractEqualsInfoDTO equalsInfoDTO,String ment);

    //멘트저장을위해 이퀄스아이디가 필요하기 때문에 이퀄스아이디 찾기 
    int findEqaulsId(ExtractEqualsInfoDTO equalsInfoDTO);
    
    //추출시 비교한후 그에 해당하는 멘트를 찾아서 보여주는 메소드
    List<ExtractMentDTO> findMents(int eqaulsId);

    
}
