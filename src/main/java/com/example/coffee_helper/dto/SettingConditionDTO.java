package com.example.coffee_helper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SettingConditionDTO {
    private int id;
    private int condition; //수치 나타냄
    private String check; // over인지 row 인제 체크
    private String option; //추출시간,추출량,원두양 선택
}
