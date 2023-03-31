package com.example.coffee_helper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtractInfoDTO {
    
    private ExtractDTO extract;
    private ExtractEqualsInfoDTO equals;
    private String ment;

    
    
}
