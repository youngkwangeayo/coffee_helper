package com.example.coffee_helper.mapper.chart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.dto.ResponseResultExtractDTO;
import com.example.coffee_helper.entity.ChartBestFive;

@Mapper
public interface ChartMapper {
    

    
    @Results(id = "bestFive", value = {
        @Result(property = "extract.id",column = "e_id"),
        @Result(property = "extract.extractTime",column = "extract_time"),
        @Result(property = "extract.beenAmount",column = "extract_been"),
        @Result(property = "extract.extractAmount",column = "extract_amount"),
        @Result(property = "extractEqualsInfoDTO.been",column = "been"),
        @Result(property = "extractEqualsInfoDTO.amount",column = "amount"),
        @Result(property = "extractEqualsInfoDTO.time",column = "time")
    })
    List<ChartBestFive> chartBestFive();
}
