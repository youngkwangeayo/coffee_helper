package com.example.coffee_helper.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommentDTO {
    private int commentId;
    private String body;
    private int boardId;
    

}
