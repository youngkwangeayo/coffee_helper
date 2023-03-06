package com.example.coffee_helper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExtractDTO {
    private int id;
    private int beenAmount;
    private int grinding;
    private int extractAmount;
    private int extractTime;
    private int beenType;
    private int resultId;
    private int mentId;
}
