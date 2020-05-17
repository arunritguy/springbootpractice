package com.hospital.specialist.details.service.api;

import java.util.List;

import com.hospital.specialist.details.model.SpecialistsDetail;

public interface HospitalSpecialistDetailService{
	
	public List<SpecialistsDetail> getSpecialistListForHospital(Integer hospitalId,String specialistType) throws Exception;
	public List<SpecialistsDetail> getSpecialistList();

}
