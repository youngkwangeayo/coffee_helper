package com.example.coffee_helper.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // w전체 
@NoArgsConstructor //기본
@Builder
public class ResponseResultExtractDTO {
    
    ExtractDTO extract;
    ExtractEqualsInfoDTO extractEqualsInfoDTO;
    List<ExtractMentDTO> ments;
    // String memo;
    

    // public ResponseResultExtractDTO( ExtractDTO extract,ExtractEqualsInfoDTO extractEqualsInfoDTO,List<ExtractMentDTO> ments){
    //     this.extract = extract;
    //     this.extractEqualsInfoDTO = extractEqualsInfoDTO;
    //     this.ments=ments;
    // }

}
