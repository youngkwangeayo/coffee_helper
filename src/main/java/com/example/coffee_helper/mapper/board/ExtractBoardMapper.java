package com.example.coffee_helper.mapper.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.coffee_helper.dto.ExtractInfoDTO;
import com.example.coffee_helper.dto.PageRequestDTO;
import com.example.coffee_helper.dto.PageResponseDTO;
import com.example.coffee_helper.entity.Extract;
import com.example.coffee_helper.entity.ExtractInfo;

@Mapper
public interface ExtractBoardMapper {
    

    @Select("select * from extract order by e_id desc Limit #{skip},#{size}")
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
    List<Extract> findBoardList(PageRequestDTO requestDTO);


    @Select("select count(e_id) from extract;")
    int boardCount();

    // @Select("select count(e_id) from extract where u_id=#{userIdx};")
    int boardCountOfUser(PageRequestDTO requestDTO,int userIdx);

    //페이징 게시글
    // @Select("select * from extract where u_id= #{userIdx} order by e_id desc Limit #{requestDTO.skip},#{requestDTO.size}")
    // @ResultMap("extract")
    List<Extract> findExtractsOfUser(PageRequestDTO requestDTO,int userIdx);



    // @Results(id="extract2", value = {
    //     @Result(property = "extract.id", column = "e_id"),
    //     @Result(property = "beenAmount", column = "been_amount"),
    //     @Result(property = "extractTime", column = "extract_time"),
    //     @Result(property = "extractAmount", column = "extract_amount"),
    //     @Result(property = "beenType", column = "been_type"),
    //     @Result(property = "userId", column = "u_id"),
    //     @Result(property = "regDate", column = "reg_date"),
    //     @Result(property = "regDateTime", column = "reg_date_time"),
    //     @Result(property = "time", column = "time"),
    //     @Result(property = "been", column = "been"),
    //     @Result(property = "amount", column = "amount")
    // })
    List<ExtractInfoDTO> findExtractInfoOfUser(PageRequestDTO requestDTO,int userIdx);
    


}

