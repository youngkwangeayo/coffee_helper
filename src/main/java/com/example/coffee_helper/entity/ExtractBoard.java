package com.example.coffee_helper.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExtractBoard {
    private int id;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;
    private int extrectId;
    private int selfResult;
    private boolean favorites;
    
}
