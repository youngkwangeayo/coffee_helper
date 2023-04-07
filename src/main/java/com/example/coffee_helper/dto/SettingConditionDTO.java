package com.example.coffee_helper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SettingConditionDTO {
    private int id;
    private int condition; //수치 나타냄
    private String check; // over인지 row 인제 체크
    private String option; //추출시간,추출량,원두양 선택

    private int amountOver;
    private int amountRow;
    private int timeRow;
    private int timeOver;
    private int beenOver;
    private int beenRow;

    

    public SettingConditionDTO(int id , int condition , String check, String option){
        this.id=id;
        this.condition=condition;
        this.check=check;
        this.option=option;
    }

    public SettingConditionDTO(int amountOver, int amountRow, int timeRow , int timeOver, int beenOver, int beenRow){
        this.amountOver = amountOver;
        this.amountRow = amountRow;
        this.beenOver = beenOver;
        this.beenRow =beenRow;
        this.timeOver = timeOver;
        this.timeRow = timeRow;
    }
    

    
}
