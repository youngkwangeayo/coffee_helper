package com.example.coffee_helper.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coffee_helper.dto.ChartBestFiveDTO;
import com.example.coffee_helper.dto.ResponseResultExtractDTO;
import com.example.coffee_helper.entity.ChartBestFive;
import com.example.coffee_helper.mapper.chart.ChartMapper;

@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    ChartMapper chartMapper;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ChartBestFiveDTO> chartBestFive() {
        List<ChartBestFive> afertList = chartMapper.chartBestFive();

        List<ChartBestFiveDTO> list = afertList.stream().map(ChartBestFive-> modelMapper.map(ChartBestFive, ChartBestFiveDTO.class))
        .collect(Collectors.toList());

        return list;
    }

    
    
    
}
