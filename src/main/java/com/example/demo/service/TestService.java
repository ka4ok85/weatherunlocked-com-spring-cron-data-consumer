package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Call;
import com.example.demo.entity.WeatherRecord;
import com.example.demo.repository.WeatherRecordRepository;

@Service
public class TestService {

	@Value("${weatherunlocked.appId}")
	private String appId;
	
	@Value("${weatherunlocked.appKey}")
	private String appKey;
	
	@Autowired
    private WeatherRecordResource weatherRecordResource;

	@Autowired
	private WeatherRecordRepository weatherRecordRepository;

	public void run(Call call) {

		float lat = call.getLatitude();
		float lon = call.getLongitude();
		LocalDateTime dateTime = call.getDatetime();
    	
		// call Weather Service
    	WeatherRecord weatherRecord = weatherRecordResource.currentWeather(lat, lon, appId, appKey);
		//WeatherRecord weatherRecord = new WeatherRecord();
    	weatherRecord.setLatitude(lat); // we want to keep 911 calls coordinates since weather coordinates are not so accurate
    	weatherRecord.setLongitude(lon);
    	weatherRecord.setDatetime(dateTime);
    	//weatherRecord.setConditionDescription("testCond");
    	//weatherRecord.setTemperature(0.1f);

		weatherRecordRepository.save(weatherRecord);
	}
}
