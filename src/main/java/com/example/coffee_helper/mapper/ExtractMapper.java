package com.example.coffee_helper.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.entity.Extract;
import com.example.coffee_helper.entity.ExtractResultMent;



@Mapper
public interface ExtractMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into extract (been_amount,extract_amount,extract_time,u_id,grinding,been_type,eq_id,memo) values(#{beenAmount},#{extractAmount},#{extractTime},#{userId},#{grinding},#{beenType},#{eq_id},#{memo});")
    @Results(id="extract", value = {
        @Result(property = "id", column = "e_id"),
        @Result(property = "beenAmount", column = "been_amount"),
        @Result(property = "extractTime", column = "extract_time"),
        @Result(property = "extractAmount", column = "extract_amount"),
        @Result(property = "beenType", column = "been_type"),
        @Result(property = "userId", column = "u_id"),
        @Result(property = "regDate", column = "reg_date"),
        @Result(property = "regDateTime", column = "reg_date_time")
    })
    int saveMachineExtract(Extract extract);  //맵퍼에 머신세이브와 유저세이브 나눈 이유 유저추출하기는 본인이 원두글라인딩 입력가능


    @Insert("insert into extract_save_ment (e_id,m_id) values(#{extractId},#{mentId});")
    @Results(id="extractSaveMent",value = {
        @Result(property = "saveId" ,column= "sm_id"),
        @Result(property = "extractId" ,column= "e_id"),
        @Result(property = "mentId" ,column= "m_id")
    })
    int saveExtractResultMent(ExtractResultMent extractResultMent);

    
}
