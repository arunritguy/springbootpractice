package com.hospital.specialist.details.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hospital.specialist.details.exception.HospitalSpecialistDetailsException;
import com.hospital.specialist.details.model.ExceptionResponse;

@ControllerAdvice
public class SpecialisDetailsExceptionHandler {

	@ExceptionHandler(HospitalSpecialistDetailsException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleValidationError(final HospitalSpecialistDetailsException exception,
			final HttpServletRequest request) {
		System.out.println("ControllerAdvice Invoked - HospitalSpecialistsDetailsException");
		System.out.println(exception.getMessage());
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		//error.callerURL(request.getRequestURI());

		return error;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleResourceResponse(final Exception exception,
			final HttpServletRequest request) {
		System.out.println("ControllerAdvice Invoked");
		System.out.println(exception.getMessage());
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		//error.callerURL(request.getRequestURI());

		return error;
	}
	
}
