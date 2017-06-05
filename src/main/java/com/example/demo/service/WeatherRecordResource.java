package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.config.FeignConfiguration;
import com.example.demo.entity.WeatherRecord;

@FeignClient(name = "weather-unlocked-service", url = "http://api.weatherunlocked.com/api", configuration = FeignConfiguration.class)
public interface WeatherRecordResource {
	
	@RequestMapping(method = RequestMethod.GET, value = "/current/{lat},{lon}")
	public WeatherRecord currentWeather(@PathVariable("lat") float lat, @PathVariable("lon") float lon, @RequestParam("app_id") String appId, @RequestParam("app_key") String appKey);
}

