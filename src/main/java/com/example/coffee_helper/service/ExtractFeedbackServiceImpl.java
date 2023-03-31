package com.example.coffee_helper.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.coffee_helper.mapper.FeedbackMentMapper;
import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.ExtractEqualsInfoDTO;
import com.example.coffee_helper.dto.ExtractMentDTO;
import com.example.coffee_helper.entity.ExtractMent;
import com.example.coffee_helper.extractSoftware.ExtractSoftService;
import com.example.coffee_helper.dto.FeedbackOption;
import com.example.coffee_helper.dto.ResponseResultExtractDTO;

@Service
public class ExtractFeedbackServiceImpl implements ExtractFeedbackService {

    @Autowired
    ExtractSoftService extractSoftWare;

    
    @Autowired
    BestConditionService conditionService;

    @Autowired
    StandardExtract standardExtract;

    @Autowired
    FeedbackMentMapper MentMapper;

    @Autowired
    ExtractMentService mentService;
    
    
    public ResponseResultExtractDTO feedbakMent(ExtractDTO extractDTO){
        
        //추출과 비교하기위해 머신에 해당 세팅값 모조리 불러오기
        // ExtractDTO extractDTO = extractSoftWare.extractSoft();
        int timeRow = standardExtract.optionRow("extraction time");
        int timeOver = standardExtract.optionOver("extraction time");
        int beenAmountRow=standardExtract.optionRow("been amount");
        int beenAmountOver=standardExtract.optionOver("been amount");
        int extractionRow=standardExtract.optionRow("extraction amount");
        int extractionOver=standardExtract.optionOver("extraction amount");

        // good,  bad-over,  bad-row
        String feedbackTime = currentStatus(extractDTO.getExtractTime(),timeRow,timeOver);
        String feedbackBeen = currentStatus(extractDTO.getBeenAmount(),beenAmountRow,beenAmountOver);
        String feedbackExtraction = currentStatus(extractDTO.getExtractAmount(),extractionRow,extractionOver);

        ExtractEqualsInfoDTO equalsInfoDTO= ExtractEqualsInfoDTO.builder()
        .time(feedbackTime)
        .amount(feedbackExtraction)
        .been(feedbackBeen)
        .build();

        System.out.println(equalsInfoDTO);
        int eqaulsId =mentService.findEqaulsId(equalsInfoDTO);
        equalsInfoDTO.setId(eqaulsId);
        extractDTO.setEq_id(eqaulsId);

        List<ExtractMentDTO>ments = mentService.findMents(eqaulsId);

        
        ResponseResultExtractDTO resultExtractDTO = new ResponseResultExtractDTO(extractDTO,equalsInfoDTO,ments);
        
        return resultExtractDTO;
    }

    
    
    //각조건별 결과값 얻기 굳 오버 로우
    private String currentStatus(int check,int row, int over ){
        // 각 옵션별 조건
        String option =null;
        if(row < check){
            System.out.println("최소기준점 통과");
            if(check < over){
                System.out.println("베스트조건");
                option = "good";
            }else{
                System.out.println("조건초과");
                option = "over";        
            }
        }else{
            System.out.println("조건보다 못미침");
            option = "row";
        }

        return option;
    } 

   
    
   

    /*
     * 
     *   public List<ExtractMentDTO> feedbakMent(ExtractDTO extractDTO){
        
        //추출과 비교하기위해 머신에 해당 세팅값 모조리 불러오기
        // ExtractDTO extractDTO = extractSoftWare.extractSoft();
        int timeRow = standardExtract.optionRow("extraction time");
        int timeOver = standardExtract.optionOver("extraction time");
        int beenAmountRow=standardExtract.optionRow("been amount");
        int beenAmountOver=standardExtract.optionOver("been amount");
        int extractionRow=standardExtract.optionOver("extraction amount");
        int extractionOver=standardExtract.optionOver("extraction amount");

        // good,  bad-over,  bad-row
        String feedbackTime = currentStatus(extractDTO.getExtractTime(),timeRow,timeOver);
        String feedbackBeen = currentStatus(extractDTO.getBeenAmount(),beenAmountRow,beenAmountOver);
        String feedbackExtraction = currentStatus(extractDTO.getExtractAmount(),extractionRow,extractionOver);

        ExtractEqualsInfoDTO equalsInfoDTO= ExtractEqualsInfoDTO.builder()
        .time(feedbackTime)
        .amount(feedbackExtraction)
        .been(feedbackBeen)
        .build();

        System.out.println(equalsInfoDTO);
        int eqaulsId =mentService.findEqaulsId(equalsInfoDTO);
        



        
        return mentService.findMents(eqaulsId); 
    }
     */

   


}
