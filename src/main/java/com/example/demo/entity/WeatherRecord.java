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
    
    @Column(name = "incident_number")
    private String incidentNumber;

    @JsonProperty("temp_c")
    @Column(nullable = true)
    private Float temperature;
    
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

	public String getIncidentNumber() {
		return incidentNumber;
	}

	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}

	public Float getTemperature() {
		return temperature;
	}

	public void setTemperature(Float temperature) {
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
		return "WeatherRecord [id=" + id + ", incidentNumber=" + incidentNumber + ", temperature=" + temperature
				+ ", conditionDescription=" + conditionDescription + ", datetime=" + datetime + ", zip=" + zip + "]";
	}

}
