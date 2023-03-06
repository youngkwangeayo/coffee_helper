package com.example.coffee_helper.extractSoftware;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.BestConditionDTO;
import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.service.BestConditionService;
import com.example.coffee_helper.service.BestConditionServiceImpl;

@Service
public class ExtractSoftService {
    
    @Autowired
    BestConditionService conditionService;
    
    
    
    //추출시간이 길고 원두량이 많으면 적당하거나 적은추출
    //추출시간이 짧으면 적은 추출
    //추출시간이 길면 많은 추출
    //추출시간이 길길어도 원두가 많고 분쇄도도높으면 추출이 적음
    //추출시간 값보다 원두량이 많으면 추출시간은 줄어들게끔
    
    //추출시간과 원두량이 정상이면 추출량은 추출시간보다 5정도 작음
    //그치만 가끔만 랜덤으로 출력되게 원두 분쇄도 랜덤값 저장해서 추출이 적거나 많게 구현


    public ExtractDTO extractSoft(){
        ExtractDTO extractDTO = new ExtractDTO();

        extractDTO.setExtractTime((int)(Math.random()*20)+15);
        extractDTO.setBeenAmount((int)(Math.random()*14)+7);
        int exTime = extractDTO.getExtractTime();

        //추출시간이 길고 원두량이 적으면 추출량은 많아짐
        if(extractDTO.getExtractTime()>32 && extractDTO.getBeenAmount()<12){
            //추출시간이 많으면 물이많아지고
            extractDTO.setExtractAmount((int)(Math.random()*(exTime+13))+(exTime+5));
        }
        //추출시간이 길고 원두량이 많으면 추출량은 적어짐
        if(extractDTO.getExtractTime()>32 && extractDTO.getBeenAmount()>21){
            //그치만 올바른추출이되었다? 그러면 원두 굵기가 많이굵은거 비교메소드에 참고
            extractDTO.setExtractAmount((int)(Math.random()*25)+15);
        }
        // 추출량이 추출시간에 비해 과도하게 오바되지않게
        return addExtractAount(extractDTO);
    }


    // 추출량이 추출시간에 비해 과도하게 오바되지않게 잡아주는 메소드
    private ExtractDTO addExtractAount(ExtractDTO extractDTO){
        Boolean stop = false;
        while(!stop){
            extractDTO.setExtractAmount((int)(Math.random()*25)+15);
            int result=biggerInt(extractDTO.getExtractAmount(),extractDTO.getExtractTime());
            if(result==extractDTO.getExtractAmount()){
                result = extractDTO.getExtractAmount()-extractDTO.getExtractTime();
                if(result<11){
                    stop=true;    
                }
            }else{
                result = extractDTO.getExtractTime()-extractDTO.getExtractAmount();
                if(result<11){
                    stop=true;    
                }
            }

        }
        
        return extractDTO;
    }



    private int biggerInt(int x, int y){
        if(x>y){
            return x;
        }
        return y;
    }






   
    



}
