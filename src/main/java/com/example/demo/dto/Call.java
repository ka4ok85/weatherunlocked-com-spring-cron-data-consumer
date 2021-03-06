package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.dto.CustomLocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Call {

    private Long id;
    
    private String address;
    
    private String type;
    
    private float latitude;
    
    private float longitude;
    
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime datetime;

	@JsonProperty(value = "incidentNumber")
    private String incidentNumber;

    private String zip;
	
	public Call() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIncidentNumber() {
		return incidentNumber;
	}

	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
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
		return "Call [id=" + id + ", address=" + address + ", type=" + type + ", latitude=" + latitude + ", longitude="
				+ longitude + ", datetime=" + datetime + ", incidentNumber=" + incidentNumber + ", zip=" + zip + "]";
	}

	

}
