package com.example.demo.dto;

import java.time.LocalDateTime;

public class Call {

    private Long id;
    
    private String address;
    
    private String type;
    
    private String incidentNumber;
    
    private float latitude;
    
    private float longitude;
    
    private LocalDateTime datetime;

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

	@Override
	public String toString() {
		return "Call [id=" + id + ", address=" + address + ", type=" + type + ", incidentNumber=" + incidentNumber
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", datetime=" + datetime + "]";
	}

	
    
}
