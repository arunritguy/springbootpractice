package com.hospital.frontdesk.exception;

public class HospitalFrontDeskException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 676505990414149557L;

	public HospitalFrontDeskException() {
		super();
	}

	public HospitalFrontDeskException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public HospitalFrontDeskException(String message, Throwable cause) {
		super(message, cause);
	}

	public HospitalFrontDeskException(String message) {
		super(message);
	}

	public HospitalFrontDeskException(Throwable cause) {
		super(cause);
	}

}
