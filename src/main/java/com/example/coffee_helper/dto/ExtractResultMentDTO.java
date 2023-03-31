package com.example.coffee_helper.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtractResultMentDTO {
    private int saveId;
    private int extractId;
    private int mentId;

}
