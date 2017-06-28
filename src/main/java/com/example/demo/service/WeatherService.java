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
	private HystrixWeatherService hystrixWeatherService;

	@Autowired
	private WeatherRecordRepository weatherRecordRepository;

	public void run(Call call) {
		float lat = call.getLatitude();
		float lon = call.getLongitude();
		LocalDateTime dateTime = call.getDatetime();

		WeatherRecord weatherRecord = hystrixWeatherService.getWeather(lat, lon, appId, appKey);
		if (weatherRecord == null) {
			log.error("Service: {}. Incident: {}. Can not fetch Weather data!", serviceName, call.getIncidentNumber());
			weatherRecord = new WeatherRecord();
		}

		weatherRecord.setIncidentNumber(call.getIncidentNumber());
		weatherRecord.setDatetime(dateTime);
		weatherRecord.setZip(call.getZip());

		log.info("Service: {}. Incident: {}. Fetched weatherRecord Object {}", serviceName, call.getIncidentNumber(), weatherRecord);

		weatherRecordRepository.save(weatherRecord);
	}
}
