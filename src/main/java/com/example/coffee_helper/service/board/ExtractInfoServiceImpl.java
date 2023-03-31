package com.example.coffee_helper.service.board;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.PageRequestDTO;
import com.example.coffee_helper.dto.PageResponseDTO;
import com.example.coffee_helper.dto.ResponseResultExtractDTO;
import com.example.coffee_helper.entity.Extract;
import com.example.coffee_helper.mapper.board.ExtractBoardMapper;


// @Service
public class ExtractInfoServiceImpl /*implements ExtractBoardService*/{

    // @Autowired
    // ExtractBoardMapper boardMapper;

    // ModelMapper modelMapper = new ModelMapper();


    // @Override
    // public PageResponseDTO<?> findBoardList(PageRequestDTO requestDTO) {
        
        
    //     throw new UnsupportedOperationException("Unimplemented method 'findBoardList'");
    // }

    // @Override
    // public List<ExtractDTO> findBList(PageRequestDTO requestDTO) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'findBList'");
    // }


    // @Override
    // public PageResponseDTO<?> findBoardList(PageRequestDTO requestDTO, int userId) {
        

    //     throw new UnsupportedOperationException("Unimplemented method 'findBoardList'");
    // }

    // @Override
    // public List<?> findBList(PageRequestDTO requestDTO, int userId) {
    //     List<Extract> afterList=boardMapper.findExtractInfoList(requestDTO, userId);

    //     List<ExtractDTO> list = afterList.stream()
    //     .map(Extract->modelMapper.map(Extract, ExtractDTO.class))
    //     .collect(Collectors.toList());
    //     return list;
    // }
    
}
