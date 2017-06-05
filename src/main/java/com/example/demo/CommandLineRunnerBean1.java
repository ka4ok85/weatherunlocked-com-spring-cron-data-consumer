package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Call;
import com.example.demo.entity.WeatherRecord;
import com.example.demo.repository.WeatherRecordRepository;
import com.example.demo.service.WeatherRecordResource;

@Component
public class CommandLineRunnerBean1 implements CommandLineRunner {

	@Value("${weatherunlocked.appId}")
	private String appId;
	
	@Value("${weatherunlocked.appKey}")
	private String appKey;
	
	@Autowired
    private WeatherRecordResource weatherRecordResource;

	@Autowired
	private WeatherRecordRepository weatherRecordRepository;
	
	@Override    
    public void run(String... args) throws Exception {
/*
		//String json = {"id":"1", "address":"915 2nd Av", "type":"Aid Response", "incidentNumber":"F170055300", "latitude":"47.6016", "longitude":"-122.302284", "datetime":"2017-06-05T07:55"} 
		Call call = new Call();
		call.setId(1L);
		call.setAddress("915 2nd Av");
		call.setType("Aid Response");
		call.setIncidentNumber("F170055300");
		call.setLatitude(47.6016f);
		call.setLongitude(-122.302284f);
		LocalDateTime datetime = LocalDateTime.parse("2017-06-05T07:55");
		call.setDatetime(datetime);

		float lat = call.getLatitude();
		float lon = call.getLongitude();
		
		
		//float lat = 47.604549f;
		//float lon = -122.334572f;
    	
    	
    	WeatherRecord weatherRecord = weatherRecordResource.currentWeather(lat, lon, appId, appKey);
    	// we want to keep 911 calls coordinates since weather coordinates are not so accurate
    	weatherRecord.setLatitude(lat);
    	weatherRecord.setLongitude(lon);
System.out.println(weatherRecord);

		weatherRecordRepository.save(weatherRecord);
*/    	
    }
}
