package com.hospital.frontdesk.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="error")
public class ErrorResponse {

	private String message;

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}
	
}
