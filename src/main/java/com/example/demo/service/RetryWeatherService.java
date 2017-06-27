package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import feign.FeignException;

import com.example.demo.entity.WeatherRecord;
import com.example.demo.exceptions.WeatherRecordResourceException;

@Component
public class RetryWeatherService {
	private static final Logger log = LoggerFactory.getLogger(RetryWeatherService.class);

	@Value("${service.name}")
	private String serviceName;

	@Autowired
	private WeatherRecordResource weatherRecordResource;

	@Retryable(value = { FeignException.class }, maxAttempts = 3)
	public WeatherRecord requestWeather(float lat, float lon, String appId, String appKey) {
		WeatherRecord weatherRecord = weatherRecordResource.currentWeather(lat, lon, appId, appKey);

		return weatherRecord;
	}

	@Recover
	public WeatherRecord requestWeatherRetryFallback(FeignException e) throws WeatherRecordResourceException {
		log.warn("Service: {}. Can not fetch data from WeatherUnlocked after 3 retries", serviceName);

		throw new WeatherRecordResourceException();
	}
}
