package com.hospital.specialist.details.service.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hospital.specialist.details.exception.HospitalSpecialistDetailsException;
import com.hospital.specialist.details.model.SpecialistsDetail;
import com.hospital.specialist.details.service.api.HospitalSpecialistDetailService;

@Service
public class HospitalSpecialistDetailServiceImpl implements HospitalSpecialistDetailService{
	
	static List<SpecialistsDetail> specialistDetails;
	
	static {
		specialistDetails=new ArrayList<>();
		SpecialistsDetail sp=null;
		/*
		 * SpecialistsDetail sp1=null; SpecialistsDetail sp2=null; SpecialistsDetail
		 * sp3=null; SpecialistsDetail sp4=null; SpecialistsDetail sp5=null;
		 * SpecialistsDetail sp6=null;
		 */
		
		sp = new SpecialistsDetail("Dentist", "Sandhya", "Mon,Wed", "9-5", "Y", 946);
		specialistDetails.add(sp);
		sp = new SpecialistsDetail("Pharmacist", "Kumar", "Wed,Thu", "5-10", "Y", 879);
		specialistDetails.add(sp);
		sp= new SpecialistsDetail("Cardiologist", "Shravan", "Wed,Thu", "5-10", "Y", 879);
		specialistDetails.add(sp);
		sp= new SpecialistsDetail("Psychatrist", "Vanitha", "Wed,Thu", "5-10", "Y", 879);
		specialistDetails.add(sp);
		sp= new SpecialistsDetail("Pharmacist", "Karthik", "Wed,Thu", "5-10", "Y", 889);
		specialistDetails.add(sp);
		sp= new SpecialistsDetail("Cardiologist", "Akash", "Wed,Thu", "5-10", "Y", 879);
		specialistDetails.add(sp);
		sp= new SpecialistsDetail("General", "Vinayak", "Wed,Thu", "5-10", "Y", 889);
		specialistDetails.add(sp);
		
		/*
		 * ;specialistDetails.add(sp1);specialistDetails.add(sp2);specialistDetails.add(
		 * sp3);
		 * specialistDetails.add(sp4);specialistDetails.add(sp5);specialistDetails.add(
		 * sp6);
		 */
	}
	
	@Override
	@Cacheable("specialistlist")
	public List<SpecialistsDetail> getSpecialistListForHospital(Integer hospitalId,String specialistType) throws Exception {
		List<SpecialistsDetail> specialistListOfHospital=new ArrayList<>();
		boolean isHospitalAvailable=false;
		boolean isSpecialistAvailable=false;
		
		/*
		 * SpecialistsDetail sp1=null; SpecialistsDetail sp2=null; SpecialistsDetail
		 * sp3=null; SpecialistsDetail sp4=null; SpecialistsDetail sp5=null;
		 * SpecialistsDetail sp6=null;
		 */
		try {
			if(hospitalId==null || specialistType==null || specialistType.trim().equals("")) {
				throw new HospitalSpecialistDetailsException("Input Data Invalid");
			}
			
			Thread.sleep(100*5);
			
			for(SpecialistsDetail spDtls:specialistDetails) {
				if(spDtls.getHospitalId().equals(hospitalId)) {
					isHospitalAvailable=true;
					if(spDtls.getType().equalsIgnoreCase(specialistType)) {
						isSpecialistAvailable=true;
						specialistListOfHospital.add(spDtls);
					}
				}
			}
			
			
			if(!isHospitalAvailable) {
				throw new HospitalSpecialistDetailsException("No Hospital details found");
			}
				
			if(!isSpecialistAvailable) {
				throw new HospitalSpecialistDetailsException("No Specialist details found for the hospital");
			}
			
		
		return specialistListOfHospital;
		
		}catch (Exception e) {
			if(e instanceof HospitalSpecialistDetailsException) {
				throw e;
			}else
				throw new HospitalSpecialistDetailsException("INTERNAL SERVER ERROR");
		}
	}
	
	@Override
	public List<SpecialistsDetail> getSpecialistList() {
		List<SpecialistsDetail> specialistsDtls = null;
		try {

			specialistsDtls = specialistDetails;

			if (specialistsDtls == null || specialistsDtls.size() == 0) {
				throw new HospitalSpecialistDetailsException("No Specialist lists found");
			}

			return specialistsDtls;

		} catch (Exception e) {
			if (e instanceof HospitalSpecialistDetailsException) {
				throw e;
			} else
				throw new HospitalSpecialistDetailsException("INTERNAL SERVER ERROR");
		}
	}
	}
