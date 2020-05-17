package com.hospital.specialist.details.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.specialist.details.exception.HospitalSpecialistDetailsException;
import com.hospital.specialist.details.model.SpecialistsDetail;

@RestController
public class HospitalSpecialistDetailsController {

	@Autowired
	HospitalSpecialistDetailService specialistDetailService;
	
	
	
	@GetMapping(path="${getspecialistlist}")
	public List<SpecialistsDetail> getSpecialistsListOfHospital() throws HospitalSpecialistDetailsException{
		return specialistDetailService.getSpecialistList();
		 
	}
	
	/* Requirement 1 - Retrieve Specialist Details */
	@GetMapping(path="${getspecialistsdetailofhospital}")
	public List<SpecialistsDetail> getSpecialistsListOfHospital(@RequestParam("hospitalId") Integer hospitalId,@RequestParam("specialistType") String specialistType) throws Exception{
			return specialistDetailService.getSpecialistListForHospital(hospitalId, specialistType);
			 
	}
	
}
