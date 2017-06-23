package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.Call;

@Service
public class AMQPHandler {

    @Autowired
    private WeatherService weatherService; 

    @StreamListener("input")
    //@Transactional
    public void process(Call call) throws Exception {
    	weatherService.run(call);
    }
}