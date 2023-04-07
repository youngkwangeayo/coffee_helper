package com.example.coffee_helper.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SettingCondition {
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

    

    public SettingCondition(int id , int condition , String check, String option){
        this.id=id;
        this.condition=condition;
        this.check=check;
        this.option=option;
    }

    public SettingCondition(int amountOver, int amountRow, int timeRow , int timeOver, int beenOver, int beenRow){
        this.amountOver = amountOver;
        this.amountRow = amountRow;
        this.beenOver = beenOver;
        this.beenRow =beenRow;
        this.timeOver = timeOver;
        this.timeRow = timeRow;
    }
}
