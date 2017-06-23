package com.example.demo.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Call;
import com.example.demo.entity.WeatherRecord;
import com.example.demo.repository.WeatherRecordRepository;

import feign.FeignException;

@Service
public class WeatherService {

	private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
	
    @Value("${service.name}")
    private String serviceName;

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
    	
		try {
			// call Weather Service
	    	WeatherRecord weatherRecord = weatherRecordResource.currentWeather(lat, lon, appId, appKey);
	    	weatherRecord.setLatitude(lat); // we want to keep 911 calls coordinates since weather coordinates are not so accurate
	    	weatherRecord.setLongitude(lon);
	    	weatherRecord.setDatetime(dateTime);
	    	weatherRecord.setZip(call.getZip());
			weatherRecordRepository.save(weatherRecord);

			log.info("Service: {}. Incident: {}. Fetched weatherRecord Object {}", serviceName, call.getIncidentNumber(), weatherRecord);
	    } catch (FeignException e) {
	    	log.error("Service: {}. Can not fetch data from: {}", serviceName, e.getMessage());
		}
	}
}
