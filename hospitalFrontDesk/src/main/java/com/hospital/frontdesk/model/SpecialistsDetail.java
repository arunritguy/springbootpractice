package com.hospital.frontdesk.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 779185
 * 
 *         Model class to hold details of Specialists
 * 
 */
@XmlRootElement(name="item")
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder= {"type","name","availableDay","availableTime","isAvailable","hospitalId"})
public class SpecialistsDetail {

	
	private String type;

	
	private String name;

	
	private String availableDay;

	
	private String availableTime;

	
	private String isAvailable;

	
	private Integer hospitalId;
	

	public SpecialistsDetail() {
		
	}
	
	public SpecialistsDetail(String type, String name, String availableDay, String availableTime, String isAvailable,
			Integer hospitalId) {
		super();
		this.type = type;
		this.name = name;
		this.availableDay = availableDay;
		this.availableTime = availableTime;
		this.isAvailable = isAvailable;
		this.hospitalId = hospitalId;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("availableday")
	public String getAvailableDay() {
		return availableDay;
	}

	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}

	@JsonProperty("availableTime")
	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	
	@JsonProperty("isAvailable")
	public String getAvailable() {
		return isAvailable;
	}

	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	@JsonProperty("hospitalId")
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

}
