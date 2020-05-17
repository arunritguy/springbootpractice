package com.hospital.frontdesk.data.service.api;

import java.util.List;

import com.hospital.frontdesk.model.SpecialistAppointmentDetails;
import com.hospital.frontdesk.model.SpecialistsDetail;

public interface HospitalFrontDeskService {
	
	public List<SpecialistsDetail> getSpecialistListForAHospital(String hospitalId, String specialistType); 

	public SpecialistAppointmentDetails getSpecialistsAppointment(String specialistName,String appointmentDay,String patientName);
	
	public String getNoOfBedsInHospitalForAdmission(String hospitalName) throws Exception;
	
	public List<SpecialistsDetail> getSpecialistDetailsRest(String port,String environment,String url,String acceptType,String hospitalId,String specialistType) throws Exception ;
	
}
