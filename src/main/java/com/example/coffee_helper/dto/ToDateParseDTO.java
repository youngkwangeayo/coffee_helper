package com.example.coffee_helper.dto;

import java.time.LocalDate;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ToDateParseDTO {
    
    String beforeFrom;
    String beforeTO;

    LocalDate from;
    LocalDate to;

    public ToDateParseDTO(String beforeFrom,String beforeTO){
        this.beforeFrom = beforeFrom;
        this.beforeTO = beforeTO;

        this.from = LocalDate.parse(beforeFrom);
        this.to = LocalDate.parse(beforeTO);

        int resutl = from.compareTo(to);
        if(resutl>0){
            this.to=from;
            this.from=to;
        }else{
            this.to=to;
            this.from=from;
        }

    }


}
