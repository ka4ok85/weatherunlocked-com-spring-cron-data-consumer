package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.example.demo.entity.WeatherRecord;

@Component
public class HystrixWeatherService {

	private static final Logger log = LoggerFactory.getLogger(HystrixWeatherService.class);

	@Autowired
	private RetryWeatherService retryWeatherService;

	@Value("${service.name}")
	private String serviceName;

	@HystrixCommand(fallbackMethod = "getWeatherFallback")
	public WeatherRecord getWeather(float lat, float lon, String appId, String appKey) {
		WeatherRecord weatherRecord = retryWeatherService.requestWeather(lat, lon, appId, appKey);

		return weatherRecord;
	}

	public WeatherRecord getWeatherFallback(float lat, float lon, String appId, String appKey) {
		log.warn("Service: {}. Circuit Breaker Fallback Method returned null", serviceName);

		return null;
	}
}
