package com.example.coffee_helper.service.board;

import java.util.List;

import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.PageRequestDTO;
import com.example.coffee_helper.dto.PageResponseDTO;

public interface ExtractBoardService {
    

    PageResponseDTO<?> findBoardList(PageRequestDTO requestDTO);

    List<?> findBList(PageRequestDTO requestDTO);

    //밑에거는 마이보드만 보기
    PageResponseDTO<?> findBoardList(PageRequestDTO requestDTO,int userId);

    List<?> findBList(PageRequestDTO requestDTO,int userId);
}
