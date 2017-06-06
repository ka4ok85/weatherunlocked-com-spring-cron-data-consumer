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

		/*
		// temporary 911 call
		Call call = new Call();
		call.setId(1L);
		call.setAddress("915 2nd Av");
		call.setType("Aid Response");
		call.setIncidentNumber("F170055300");
		call.setLatitude(47.6016f);
		call.setLongitude(-122.302284f);
		LocalDateTime datetime = LocalDateTime.parse("2017-06-05T07:55");
		call.setDatetime(datetime);
*/
		float lat = call.getLatitude();
		float lon = call.getLongitude();
		LocalDateTime dateTime = call.getDatetime();
System.out.println(dateTime);    	
		// call Weather Service
    	//WeatherRecord weatherRecord = weatherRecordResource.currentWeather(lat, lon, appId, appKey);
		WeatherRecord weatherRecord = new WeatherRecord();
    	weatherRecord.setLatitude(lat); // we want to keep 911 calls coordinates since weather coordinates are not so accurate
    	weatherRecord.setLongitude(lon);
    	weatherRecord.setDatetime(dateTime);
    	weatherRecord.setConditionDescription("testCond");
    	weatherRecord.setTemperature(0.1f);

    	// 2007-12-03T10:15:30
    	System.out.println(weatherRecord);

		weatherRecordRepository.save(weatherRecord);
	}
}
