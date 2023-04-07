package com.example.coffee_helper.mapper.condition;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.coffee_helper.entity.BestCondition;
import com.example.coffee_helper.entity.SettingCondition;


@Mapper
public interface BestConditionMapper {

    
    @Results(id="BestCondition", value ={
        @Result(property = "id", column = "c_id"),
        @Result(property = "condition", column = "c_condition"),
        @Result(property = "check", column = "c_check"),
        @Result(property = "option", column = "c_option")
    })
    @Select("select * from best_condition_default;")
    List<BestCondition> findAllDefaultCondition();
    
    
    @Results(id="settingCondition", value ={
        @Result(property = "id", column = "sc_id"),
        @Result(property = "condition", column = "sc_condition"),
        @Result(property = "check", column = "sc_check"),
        @Result(property = "option", column = "sc_option")
    })
    @Select("select * from setting_condition;")
    List<BestCondition> findSettingCondition();
    
    // 관리자가 커피 비교 기본값으로 할것인지 셋팅값으로 비교할것인지 체크
    @Select("select s_check from choice_setting;")
    Boolean checkSetting();
    
    //셋팅 선택
    @Update("update choice_setting set s_check=#{check} where idx=1;")
    int settingChange(Boolean check);


    void settingOptionChang(SettingCondition settingCondition);
    
}
