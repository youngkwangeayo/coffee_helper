package com.example.coffee_helper.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.coffee_helper.entity.TestC;

@Mapper
public interface Test_cMapper {
    
    TestC findALl();
}
