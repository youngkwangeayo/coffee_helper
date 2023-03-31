package com.example.coffee_helper.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.entity.ExtractEqualsInfo;
import com.example.coffee_helper.entity.ExtractMent;

@Mapper
public interface ExtractMentMapper {
    
    
    @Insert("insert into extract_ment (ment,eq_id) value (#{ment},#{equalsId});")
    @Results(id="ments",value={
        @Result(property = "id", column = "m_id"),
        @Result(property = "equalsId",column = "eq_id")
    })
    int insertMent(int equalsId,String ment);


    @Select("select * from extract_ment where eq_id=#{eqaulsId}")
    @Results(id="ments",value={
        @Result(property = "id", column = "m_id"),
        @Result(property = "equalsId",column = "eq_id")
    })
    List<ExtractMent> findMents(int eqaulsId);
}
