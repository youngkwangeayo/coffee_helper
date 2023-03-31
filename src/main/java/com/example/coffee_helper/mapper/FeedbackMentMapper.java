package com.example.coffee_helper.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.entity.ExtractMent;

@Mapper
public interface FeedbackMentMapper {
    
    @Select("select * extract_ment where ment=#{ment};")
    @Results(id="ment",value={
        @Result(property = "id", column = "m_id"),
        @Result(property = "equalsId",column = "eq_id")
    })
    ExtractMent findFeedbackMent(String ment);



    //멘트불러오기 위해
    @Select("select*from extract_ment as m inner join best_condition_default as c on m.c_id =  c.c_id where c.c_option = #{feedbackOptions}  && c.c_check=#{check};")
    List<ExtractMent> findReasonableMent(String feedbackOptions, String check);
    
    
}
