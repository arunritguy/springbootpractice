package com.hospital.frontdesk.exception.handler;

public class ExceptionResponse {
	
	private String errorMessage;
	
	private String detail;
	

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
