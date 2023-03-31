package com.example.coffee_helper.extractSoftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.mapper.ExtractEqualsInfoMapper;

@Service
public class ExtractEqualsInfoService {
    
    @Autowired
    ExtractEqualsInfoMapper extractEqualsInfo;
   

    public int designateMentNum(){
        String[] results = {"over","good","row"};
        int count =0;
        for(int i=0; i<results.length; i++){

            for(int j=0; j<results.length; j++){

                for(int k=0; k<results.length; k++){

                	 count ++;
                     System.out.println(count);
                     System.out.println("타임 :"+results[i] + "  원두양 :"+results[j]+"  추추량 :"+results[k]);
                      int result=extractEqualsInfo.designateMentNum(results[i], results[j], results[k]);

                      if(result<0){
                        return 0;
                      }
//                    if(feedbackTime.equals(result[i]) && feedbackBeen.equals(result[j])){
//                        if(feedbackExtraction.equals(result[k])){
//                            count ++;
//                            System.out.println(count);
//                            System.out.println("타임 :"+result[i] + "  원두양 :"+result[j]+"  추추량 :"+result[k]);
//                        }
//                    }
            
                }

            }

        }
        
        //맵으로 반환 맵을 풀어주는 메소드도 만들고 
        return 1;
    }
}
