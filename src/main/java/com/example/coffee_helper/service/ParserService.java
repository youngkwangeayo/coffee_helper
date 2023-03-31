package com.example.coffee_helper.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParserService {
    
    ModelMapper modelMapper = new ModelMapper();


    // public Object parseEntity(Object DTO){
    //     Object entity = modelMapper.map(DTO, Object.class);
        

    //     return entity;
    // }

    public Object parseDomain(Object input,Object output){
        output = modelMapper.map(input,output.getClass());
        

        return output;
    }


    // public List<Object> parseListDomain(List<Object> input,List<Object>output) {
        

    //      output = input.stream()
    //     .map(input.getClass()->modelMapper.map(input.ge, output.getClass()))
    //     .collect(Collectors.toList());

    //     return output;
    // }


}
