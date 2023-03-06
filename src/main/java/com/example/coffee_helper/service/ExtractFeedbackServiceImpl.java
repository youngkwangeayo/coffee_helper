package com.example.coffee_helper.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.BestConditionDTO;

@Service
public class ExtractFeedbackServiceImpl implements ExtractFeedbackService {


    
    @Autowired
    BestConditionService conditionService;
    
     //최대한 중복을 줄이기 위해 매퍼에는 셀렉트올로 줌 맵퍼에서 쿼리문에서 값을 줘버리면 메소드가 최소 3개는 더생겨야함을 방지
    //디비에 옵션퀄럼 무엇이든 속성열의 속성에 퀄럼 컨디션,체크에 값이 추가가 되어도 안에 값이 몇개인지,값이 뭔지몰라도 구동이 되게끔 자바처리함
    public int optionRow(String option){
        HashMap<Object, Object> map = new HashMap<>();
        map = extractAmount(option);
        return compareToRow(map);
    }

    public int optionOver(String option){
        HashMap<Object, Object> map = new HashMap<>();
        map = extractAmount(option);
        return compareToOver(map);
    }



    // 1_디비에저장된(소프트웨어로 api로 만들어뺀다하면 디티오에 클래스 변수로 저장되어있는 값)을 리스트로 받아
    // 옵션퀄럼에 속성이 extraction amount(추출량) 인 경우 속성값을 맵에 담음
    private HashMap<Object, Object> extractAmount(String option){
        List<BestConditionDTO>conditionDTOs=conditionService.findAllCondition();
        HashMap<Object, Object> extractAmountMap = new HashMap<>();
        int j=0;
        for(int i=0; i<conditionDTOs.size(); i++){
            if(conditionDTOs.get(i).getOption().equals(option)){
                extractAmountMap.put(j, conditionDTOs.get(i).getCondition());
                j++;
            }
        }    
        return extractAmountMap;
    }    
    
    
    //2_ 1번에처리한 값을몰라도 알고리즘으로 맵의 값과 갯수를 알아내 배열을 사용하여 최저값 반환
    private int compareToRow(HashMap<Object, Object> map){
        int tmep =0;
        for(Object o : map.keySet()){
            tmep+=1;
        }    
        int[]arry=new int[tmep];
        for(Object o : map.keySet()){
            arry[(int)o]=(int)map.get(o);
        }   
        Arrays.sort(arry);
       

        return arry[0];
    }

     //2_ 1번에처리한 값을몰라도 알고리즘으로 맵의 값과 갯수를 알아내 배열을 사용하여 최값 반환
     private int compareToOver(HashMap<Object, Object> map){
        int tmep =0;
        for(Object o : map.keySet()){
            tmep+=1;
        }     
        Integer[]arry=new Integer[tmep];
        for(Object o : map.keySet()){
            arry[(int)o]=(int)map.get(o);
        }    
        Arrays.sort(arry,Collections.reverseOrder());
        
       

        return arry[0];
    }    



}
