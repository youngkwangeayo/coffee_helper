package com.example.coffee_helper.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageResponseDTO<E> {
    

    private int page;
    private int size;

    private int total;
    private List<E> dtoList;
    // private ResponseExtractInfoDTO infoDTO;

    private int startPage;
    private int endPage;

    private Boolean prev;
    private Boolean next;

    private LocalDate from;
    private LocalDate to;

    private String type;
    private String keyword;

    public PageResponseDTO(PageRequestDTO requestDTO, List<E>dtoList,int total){
        this.page = requestDTO.getPage();
        this.size = requestDTO.getSize();
        
        this.total = total;
        this.dtoList = dtoList;
        
        this.endPage = (int)Math.ceil(this.page/(double)10)*10;
        this.startPage = endPage-9;
        int last = (int)Math.ceil((total/(double)size));
        this.endPage = endPage>last? last : endPage;

        this.prev = this.page>1;
        this.next = this.total>this.page*10;

        this.from = requestDTO.getFrom();
        this.to = requestDTO.getTo();

        this.type = requestDTO.getType();
        this.keyword = requestDTO.getKeyword();
    }

    // public PageResponseDTO(PageRequestDTO requestDTO, ResponseExtractInfoDTO infoDTO,int total){
    //     this.page = requestDTO.getPage();
    //     this.size = requestDTO.getSize();
        
    //     this.total = total;
    //     this.infoDTO = infoDTO;
        
    //     this.endPage = (int)Math.ceil(this.page/(double)10)*10;
    //     this.startPage = endPage-9;
    //     int last = (int)Math.ceil((total/(double)size));
    //     this.endPage = endPage>last? last : endPage;

    //     this.prev = this.page>1;
    //     this.next = this.total>this.page*10;


    // }
    

}
