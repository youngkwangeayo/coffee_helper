package com.example.coffee_helper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChartBestFiveDTO {
    int extractId;
    int extractTime;
    int beenAmount;
    int extractAmount;
    String amount;
    String been;
    String time;

}
