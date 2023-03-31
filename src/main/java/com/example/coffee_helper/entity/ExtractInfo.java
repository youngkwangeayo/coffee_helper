package com.example.coffee_helper.entity;

import com.example.coffee_helper.dto.ExtractDTO;
import com.example.coffee_helper.dto.ExtractEqualsInfoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtractInfo {
    
    private ExtractDTO extractDTO;
    
    private String time;
    private String been;
    private String amount;
    private String ment;

}
