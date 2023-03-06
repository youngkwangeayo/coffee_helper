package com.example.coffee_helper.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.entity.TestC;

@Mapper
public interface TestDMapper {
    
    @Select("select *from test_c;")
    TestC findAll2();
}
