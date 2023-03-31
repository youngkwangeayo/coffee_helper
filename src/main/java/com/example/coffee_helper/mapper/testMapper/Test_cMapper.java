package com.example.coffee_helper.mapper.testMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.entity.ChartBestFive;
import com.example.coffee_helper.entity.TestC;

@Mapper
public interface Test_cMapper {
    
    TestC findALl();

    @Select("select *from test_c;")
    TestC findAll2();


    List<ChartBestFive> testFive();
     
}
