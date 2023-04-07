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

    
    private String type;
    private String keyword;
    
    
    private String beforeFrom;
    private String beforeTo;

    private LocalDate from;
    private LocalDate to;

    public int getSkip(){
        return (page-1)*10;
    }
    
   
    public void setBeforeFrom(String beforeFrom){
        this.beforeFrom=beforeFrom;
        if(beforeFrom!=null & !beforeFrom.equals("")){
            this.from = LocalDate.parse(beforeFrom);
        }
   }

    public void setBeforeTo(String beforeTo){
        this.beforeTo = beforeTo;
        if(beforeTo!=null & !beforeTo.equals("")){
            this.to = LocalDate.parse(beforeTo);
        }
    }


    public PageRequestDTO(String beforeFrom, String beforeTo, String type, String keyword){
        this.type=type;
        this.keyword =keyword;

        this.from = LocalDate.parse(beforeFrom);
        this.to = LocalDate.parse(beforeTo);

       
        int result = from.compareTo(to);
        
        this.from = result>0? to:from;
        this.to = result>0? from:to ; 
        
    }

    public PageRequestDTO(String beforeFrom, String beforeTo, String type, String keyword,int page){
        this.page =page;
        this.type=type;
        this.keyword =keyword;
        
        this.from = LocalDate.parse(beforeFrom);
        this.to = LocalDate.parse(beforeTo);

        int result = from.compareTo(to);

        this.from = result>0? to:from;
        this.to = result>0? from:to ; 
        
    }

    

}
