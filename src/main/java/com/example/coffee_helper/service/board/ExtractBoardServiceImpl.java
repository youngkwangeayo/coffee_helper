package com.example.coffee_helper.service.board;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.ExtractInfoDTO;
import com.example.coffee_helper.dto.PageRequestDTO;
import com.example.coffee_helper.dto.PageResponseDTO;
import com.example.coffee_helper.dto.ResponseExtractInfoDTO;
import com.example.coffee_helper.entity.Extract;
import com.example.coffee_helper.mapper.board.ExtractBoardMapper;
import com.example.coffee_helper.service.ExtractSerive;
import com.example.coffee_helper.service.member.user.UserServiceImpl;

@Service
public class ExtractBoardServiceImpl implements ExtractBoardService {

    @Autowired
    ExtractBoardMapper boardMapper;

    @Autowired
    ExtractSerive extractSerive;
    
    
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ExtractDTO> findBList(PageRequestDTO requestDTO) {
        System.out.println("제네릭?사용 보드서비스");
        List<Extract>afterList = boardMapper.findBoardList(requestDTO);

        List<ExtractDTO> list = afterList.stream()
        .map(Extract-> modelMapper.map(Extract, ExtractDTO.class))
        .collect(Collectors.toList());

        return list;
    }

    @Override
    public PageResponseDTO<ExtractDTO> findBoardList(PageRequestDTO requestDTO) {
        System.out.println("제네릭?사용 보드서비스");
        int total = boardMapper.boardCount();
        List<ExtractDTO>list=findBList(requestDTO);
        PageResponseDTO<ExtractDTO> responseDTO = new PageResponseDTO<>(requestDTO, list, total);

        return responseDTO;
    }

    @Override
    public PageResponseDTO<?> findBoardList(PageRequestDTO requestDTO, int userId) {
        //테이블합친거에 추출정보
        System.out.println(userId);
        List<ExtractInfoDTO> extractInfoList = boardMapper.findExtractInfoOfUser(requestDTO,userId);
        System.out.println(requestDTO);
        int total = boardMapper.boardCountOfUser(requestDTO,userId);

        PageResponseDTO<ExtractInfoDTO> responseDTO = new PageResponseDTO<>(requestDTO,extractInfoList,total);

        return responseDTO;
    }
    
    @Override
    public List<ExtractDTO> findBList(PageRequestDTO requestDTO, int userId) {
        List<Extract> afterList=boardMapper.findExtractsOfUser(requestDTO, userId);

        List<ExtractDTO> list = afterList.stream()
        .map(Extract->modelMapper.map(Extract, ExtractDTO.class))
        .collect(Collectors.toList());
        return list;
    }

    //-1이면 멘트 삭제 오류 -2면 추출삭제오류
    @Override
    public int deleteExtractToId(int[] extractId) {
        int result =0;
        for(int i=0; i<extractId.length; i++){
            // int extractIdx = Integer.parseInt(extractId[i]);
            result=extractSerive.deleteExtractAndSaveMent(extractId[i]);
            if(result<0){
                return result;
            }
        }

        return result;
    }
    

    


    
}
