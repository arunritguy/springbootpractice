package com.hospital.frontdesk.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource(value="file:${specialistproperties.location}/specialist.properties",ignoreResourceNotFound=true)
public class SpecialistProperties {

	String[] name;
	String[] availableday;
	String[] availabletime;
	
	
	public String[] getName() {
		return name;
	}


	public void setName(String[] name) {
		this.name = name;
	}


	public String[] getAvailableday() {
		return availableday;
	}


	public void setAvailableday(String[] availableday) {
		this.availableday = availableday;
	}


	public String[] getAvailabletime() {
		return availabletime;
	}


	public void setAvailabletime(String[] availabletime) {
		this.availabletime = availabletime;
	}

	@Override
	public String toString() {
		return "Specialist name:"+this.name+",availableday-"+this.availableday+",availabletime-"+this.availabletime;
	}
	
}
