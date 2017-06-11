package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="weather_records")
public class WeatherRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @JsonProperty("lat")
    private float latitude;
    
    @JsonProperty("lon")
    private float longitude;

    @JsonProperty("temp_c")
    private float temperature;
    
    @JsonProperty("wx_desc")
    @Column(name = "condition_description")
    private String conditionDescription;
    
    private LocalDateTime datetime;

    private String zip;
        
	public WeatherRecord() {
		LocalDateTime datetime = LocalDateTime.now();
		this.setDatetime(datetime);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public String getConditionDescription() {
		return conditionDescription;
	}

	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "WeatherRecord [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", temperature="
				+ temperature + ", conditionDescription=" + conditionDescription + ", datetime=" + datetime + ", zip="
				+ zip + "]";
	}

}
