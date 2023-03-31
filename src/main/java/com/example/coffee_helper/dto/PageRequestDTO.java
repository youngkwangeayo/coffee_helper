package com.example.coffee_helper.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {
    
    @Default
    private int page = 1;

    @Default
    private int size = 10;

    private LocalDate from;
    private LocalDate to;

    private String type;
    private String keyword;
    

    // private String search

    public int getSkip(){
        return (page-1)*10;
    }

   


}
