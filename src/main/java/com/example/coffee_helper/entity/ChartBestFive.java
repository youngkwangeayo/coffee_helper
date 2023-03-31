package com.example.coffee_helper.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChartBestFive {
    
    int extractId;
    int extractTime;
    int beenAmount;
    int extractAmount;
    String amount;
    String been;
    String time;
}

