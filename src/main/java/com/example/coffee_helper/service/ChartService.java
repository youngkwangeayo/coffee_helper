package com.example.coffee_helper.service;

import java.util.List;

import com.example.coffee_helper.dto.ChartBestFiveDTO;
import com.example.coffee_helper.dto.ResponseResultExtractDTO;
import com.example.coffee_helper.entity.ChartBestFive;

public interface ChartService {

    List<ChartBestFiveDTO>chartBestFive();
}
