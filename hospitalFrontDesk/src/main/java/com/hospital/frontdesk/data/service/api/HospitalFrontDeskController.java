package com.hospital.frontdesk.data.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.frontdesk.exception.HospitalFrontDeskException;
import com.hospital.frontdesk.model.SpecialistAppointmentDetails;
import com.hospital.frontdesk.model.SpecialistsDetail;

@RestController
@RequestMapping("${application.contextpath}")
public class HospitalFrontDeskController {

	@Autowired
	HospitalFrontDeskService hospitalFrntDeskService;
	
	/* Requirement 2 - Return a New Appointment */
	@GetMapping(path="${getSpecialistAppointmentDetails}",produces=MediaType.APPLICATION_JSON_VALUE)
	public SpecialistAppointmentDetails getSpecialistAvailabilityDetails(@PathVariable("specialistName") String specialistName,
			@PathVariable("appointmentDay") String appointmentDay, @PathVariable("patientName") String patientName) {	
		
		 return hospitalFrntDeskService.getSpecialistsAppointment(specialistName, appointmentDay, patientName);
		
	}
	
	/*
	 * Requirement 3:– Return Number of beds available in the hospital for Admission
	 */
	@GetMapping(path="${getNoOfAvailableBedsInHospital}",produces=MediaType.APPLICATION_JSON_VALUE)
	public String getAvailableNoOfBedsFromHospital(@PathVariable("hospitalName") String hospitalName) throws Exception {
		
		return hospitalFrntDeskService.getNoOfBedsInHospitalForAdmission(hospitalName);
	}
	
	/*Requirement 4- Writing REST Client - Corresponding Requirement 1 - Available in hospitalSpecialistDetails Spring Boot Service */
	@GetMapping(path="${getspecialistsdetailslists}")
	public List<SpecialistsDetail> getSpecialistsDetailsList(@PathVariable("hospitalId") String hospitalId,
			@PathVariable("specialistType") String specialistType,@RequestParam("port") String port,@RequestParam("environment") String environment,
			@RequestParam("url") String url,@RequestParam("responseType") String acceptType) throws Exception{
			return hospitalFrntDeskService.getSpecialistDetailsRest(port, environment,url,acceptType,hospitalId, specialistType);
			 
	}
	
	/* NOT USED - Developed as part of Requirement 1 - For initial development */
	@GetMapping(path="${getspecialistslists}")
	public List<SpecialistsDetail> getSpecialistsList(@RequestParam("hospitalId") String hospitalId,@RequestParam("specialistType") String specialistType) throws HospitalFrontDeskException{
			return hospitalFrntDeskService.getSpecialistListForAHospital(hospitalId, specialistType);
			 
	}
	
}
