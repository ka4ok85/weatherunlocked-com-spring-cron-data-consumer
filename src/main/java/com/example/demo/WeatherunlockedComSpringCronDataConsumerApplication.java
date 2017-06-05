package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;


@EntityScan(basePackageClasses = { WeatherunlockedComSpringCronDataConsumerApplication.class, Jsr310JpaConverters.class })
@EnableFeignClients
@SpringBootApplication
public class WeatherunlockedComSpringCronDataConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherunlockedComSpringCronDataConsumerApplication.class, args);
	}
	
}


