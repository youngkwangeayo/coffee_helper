package com.example.coffee_helper.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseExtractInfoDTO {
    List<ExtractDTO> extract;
    List<ExtractInfoDTO> extractInfo;
}
