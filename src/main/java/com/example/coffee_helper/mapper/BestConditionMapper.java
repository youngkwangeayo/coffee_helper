package com.example.coffee_helper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.entity.BestCondition;


@Mapper
public interface BestConditionMapper {

    
    @Results(id="BestCondition", value ={
        @Result(property = "id", column = "c_id"),
        @Result(property = "condition", column = "c_condition"),
        @Result(property = "check", column = "c_check"),
        @Result(property = "option", column = "c_option")
    })
    @Select("select * from best_condition_default;")
    List<BestCondition> findAllCondition();
    
    
    
}
// private int id;
// private int condition; //수치 나타냄
// private String check; // over인지 row 인제 체크
// private String option; //추출시간,추출량,원두양 선택