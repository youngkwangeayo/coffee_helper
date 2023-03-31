package com.example.coffee_helper.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String beenType;
    private int userId;
    private int mentId;
    private LocalDateTime regDateTime;
    private LocalDate regDate;
    private int eq_id;
    private String memo;
}
