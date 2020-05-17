package com.hospital.frontdesk.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hospital.frontdesk.exception.HospitalFrontDeskException;

/**
 * 
 * @author 779185 - Arunkumar R
 * 
 * Possible Error Status Codes
 * 
 * 404 - RESOURCE NOT FOUND
	400 - BAD REQUEST
	401 - UNAUTHORIZED
	415 - UNSUPPORTED TYPE - Representation not supported for the resource
	500 - SERVER ERROR
 * 
 * */

@ControllerAdvice(value="com.hospital.frontdesk")
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(HospitalFrontDeskException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleValidationError(final HospitalFrontDeskException exception,
			final HttpServletRequest request) {
		System.out.println("ControllerAdvice Invoked");
		System.out.println(exception.getMessage());
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		//error.callerURL(request.getRequestURI());

		return error;
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleResourceResponse(final Exception e) {
		System.out.println("ControllerAdvice Invoked For Exception");
		System.out.println(e.getMessage());
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("Internal Server Error");
		return error;
	}
	
}
