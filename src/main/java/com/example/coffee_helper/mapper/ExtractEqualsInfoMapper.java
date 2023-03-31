package com.example.coffee_helper.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.entity.ExtractEqualsInfo;

@Mapper
public interface ExtractEqualsInfoMapper {
    
    @Insert("insert into extract_equals_info (time,been,amount) values(#{t},#{b},#{a});")
    int designateMentNum(String t, String b, String a);

    @Select("select id from extract_equals_info where time=#{time} AND been=#{been} AND amount=#{amount};")
    int findEqaulsId(ExtractEqualsInfo equalsInfo);
    
}
