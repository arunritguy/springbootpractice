package com.hospital.frontdesk.data.service.api.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hospital.frontdesk.data.service.api.HospitalFrontDeskService;
import com.hospital.frontdesk.exception.HospitalFrontDeskException;
import com.hospital.frontdesk.model.HospitalDetails;
import com.hospital.frontdesk.model.HospitalDetails.HospitalBedDetail;
import com.hospital.frontdesk.model.SpecialistAppointmentDetails;
import com.hospital.frontdesk.model.SpecialistProperties;
import com.hospital.frontdesk.model.SpecialistsDetail;
import com.hospital.frontdesk.utils.Constants;

@Service
public class HospitalFrontDeskServiceImpl implements HospitalFrontDeskService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	SpecialistProperties specialistProp;
	
	private String name;


	static List<HospitalDetails> hospitalDetailsList;
	
	static {
		hospitalDetailsList=new ArrayList<>();
		HospitalBedDetail hbd1=new HospitalBedDetail(1,"OCCUPIED");
		HospitalBedDetail hbd2=new HospitalBedDetail(2,"DISCHARG");
		HospitalBedDetail hbd3=new HospitalBedDetail(3,"DISCHARG");
		HospitalBedDetail hbd4=new HospitalBedDetail(4,"DISCHARG");
		List<HospitalBedDetail> hbdList1=new ArrayList<>();
		hbdList1.add(hbd1);hbdList1.add(hbd2);hbdList1.add(hbd3);hbdList1.add(hbd4);
		List<HospitalBedDetail> hbdList2=new ArrayList<>();
		hbd1=new HospitalBedDetail(1,"OCCUPIED");hbd2=new HospitalBedDetail(2,"OCCUPIED");hbd3=new HospitalBedDetail(3,"DISCHARG");
		hbdList2.add(hbd1);hbdList2.add(hbd2);hbdList2.add(hbd3);
		List<HospitalBedDetail> hbdList3=new ArrayList<>();
		hbd1=new HospitalBedDetail(1,"DISCHARG");hbd2=new HospitalBedDetail(2,"OCCUPIED");hbd3=new HospitalBedDetail(3,"DISCHARG");hbd4=new HospitalBedDetail(3,"OCCUPIED");
		hbdList3.add(hbd1);hbdList3.add(hbd2);hbdList3.add(hbd3);hbdList3.add(hbd4);
		List<HospitalBedDetail> hbdList4=new ArrayList<>();
		hbd1=new HospitalBedDetail(1,"OCCUPIED");hbd2=new HospitalBedDetail(2,"OCCUPIED");
		hbdList4.add(hbd1);hbdList4.add(hbd2);
		
		HospitalDetails hd1=new HospitalDetails("SanthoshHospital",4,hbdList1 ) ; // 3 Beds Available
		HospitalDetails hd2=new HospitalDetails("KMGHospital",3,hbdList2 ) ; // 1 Bed Available
		HospitalDetails hd3=new HospitalDetails("AMGHospital",4,hbdList3 ) ; // 2 Beds Available
		HospitalDetails hd4=new HospitalDetails("PPPHospital",2,hbdList4 ) ; // No Bed
		
		hospitalDetailsList.add(hd1);hospitalDetailsList.add(hd2);hospitalDetailsList.add(hd3);
		hospitalDetailsList.add(hd4);
	}
	
	
	@Override
	public List<SpecialistsDetail> getSpecialistListForAHospital(String hospitalId, String specialistType) {
		List<SpecialistsDetail> specialListsDtls=null;
		SpecialistsDetail sp=null;
		SpecialistsDetail sp1=null;
		SpecialistsDetail sp2=null;
		SpecialistsDetail sp3=null;
		SpecialistsDetail sp4=null;
		SpecialistsDetail sp5=null;
		SpecialistsDetail sp6=null;
		try {
			
			if(hospitalId==null || hospitalId.trim().equals("") 
					|| specialistType==null || specialistType.trim().equals("")) {
				throw new HospitalFrontDeskException(Constants.INVALID_INPUT);
			}
			
			sp = new SpecialistsDetail("Dentist", "Sandhya", "Mon,Wed", "9-5", "Y", 946);
			sp1 = new SpecialistsDetail("Pharmacist", "Kumar", "Wed,Thu", "5-10", "Y", 879);
			sp2= new SpecialistsDetail("Cardiologistt", "Shravan", "Wed,Thu", "5-10", "Y", 879);
			sp3= new SpecialistsDetail("Psychatrist", "Vanitha", "Wed,Thu", "5-10", "Y", 879);
			sp4= new SpecialistsDetail("Pharmacist", "Karthik", "Wed,Thu", "5-10", "Y", 889);
			sp5= new SpecialistsDetail("Dentist", "Akash", "Wed,Thu", "5-10", "Y", 879);
			sp6= new SpecialistsDetail("General", "Vinayak", "Wed,Thu", "5-10", "Y", 889);
			specialListsDtls = new ArrayList<>();
			specialListsDtls.add(sp);specialListsDtls.add(sp1);specialListsDtls.add(sp2);specialListsDtls.add(sp3);
			specialListsDtls.add(sp4);specialListsDtls.add(sp5);specialListsDtls.add(sp6);

			if (specialListsDtls == null || specialListsDtls.size() == 0) {
				throw new HospitalFrontDeskException(Constants.NO_SPECIALISTS_DETAILS);
			}
		
		return specialListsDtls;
		
		}catch (Exception e) {
			if(e instanceof HospitalFrontDeskException) {
				throw e;
			}else
				throw new HospitalFrontDeskException(Constants.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public SpecialistAppointmentDetails getSpecialistsAppointment(String specialistName, String appointmentDay,
			String patientName) {
		
		if(specialistName==null || specialistName.trim().equals("")
				|| appointmentDay==null || appointmentDay.trim().equals("")
				|| patientName==null || patientName.trim().equals("")) {
			throw new HospitalFrontDeskException(Constants.INVALID_INPUT);
		}
		
		
		List<String> specialistNameStaticList=Arrays.asList(specialistProp.getName());
		specialistNameStaticList.replaceAll(String::toUpperCase);
		SpecialistAppointmentDetails spAppointDtls=null;
		if(specialistNameStaticList.contains(specialistName.toUpperCase())) {
			
			 for(int i=0;i<specialistNameStaticList.size();i++) {
				 if(specialistName.equalsIgnoreCase(specialistNameStaticList.get(i))) {
					 if(specialistProp.getAvailableday()[i].toUpperCase().contains(appointmentDay.toUpperCase())) {
						 spAppointDtls=new SpecialistAppointmentDetails();
						 spAppointDtls.setAppointmentTime(specialistProp.getAvailabletime()[i]);
						 spAppointDtls.setAppointmentDay(appointmentDay);
						 spAppointDtls.setPatientName(patientName);
						 spAppointDtls.setSpecialistName(specialistNameStaticList.get(i));
						 break;
					 }
				 }
			 }
			
		}else {
			throw new HospitalFrontDeskException(Constants.NO_RECORDS_FOUND);
		}
		
		/*
		 * if(spAppointDtls==null) { throw new
		 * HospitalFrontDeskException(Constants.NO_SPECIALISTS_ON_AVAILABLE_DAY); }
		 */
		
		return spAppointDtls;
	}
	
	

	public String getName() {
		return name;
	}

	@Override
	public String getNoOfBedsInHospitalForAdmission(String hospitalName) throws Exception {
	
		boolean isBedAvailable=false;
		boolean isHospitalAvailable=false;
		int bedAvailableCount=0;
		String bedsAvailability;
		try {
		if(hospitalName==null || hospitalName.trim().equals("")) {
			throw new HospitalFrontDeskException(Constants.INVALID_INPUT);
		}
		
		System.out.println("Incoming HospitalName For BedCount Check:"+hospitalName);
		
		for(HospitalDetails hospitalDetail:hospitalDetailsList) {
			if(hospitalDetail.getHospitalName().equalsIgnoreCase(hospitalName)) {
				isHospitalAvailable=true;
				int bedCount=0;
				for(HospitalBedDetail hbd:hospitalDetail.getBedDetailsList()) {
					if(hbd.getPatientStatus().equals("DISCHARG")) {
						bedCount++;
					}
				}
				if(bedCount>0) {
					isBedAvailable=true;
					bedAvailableCount=bedCount;
				}
			}
		}
		
		if(!isHospitalAvailable)
			throw new HospitalFrontDeskException(Constants.NO_RECORDS_FOUND);
		
		if(!isBedAvailable)
			throw new HospitalFrontDeskException(Constants.NO_BEDS_AVAILABLE);
		
		bedsAvailability="Number of Beds Available is ="+String.valueOf(bedAvailableCount);
		}catch(Exception e) {
			if(e instanceof HospitalFrontDeskException) {
				throw e;
			}else
				throw new Exception(e.getMessage());
		}
		return bedsAvailability;
	}
	
	@Override
	public List<SpecialistsDetail> getSpecialistDetailsRest(String port,String environment,String url,String acceptType,String hospitalId,String specialistType) throws Exception {
		
		try {
			
			if (environment == null || environment.equals("") || port == null | port.equals("") || hospitalId == null
					|| hospitalId.equals("") || specialistType == null || specialistType.equals("") || url == null
					|| url.equals("") || acceptType==null || acceptType.equals("")) {
				throw new HospitalFrontDeskException(Constants.INVALID_INPUT);
			}
			
			String uri = "http://" + environment + ":" + port + "/" + url + "?hospitalId=" + hospitalId
					+ "&specialistType=" + specialistType;
			
			System.out.println("Framed URL For SpecialistList:"+uri);
			HttpHeaders headers=new HttpHeaders();
			headers.setAccept(Collections.singletonList(acceptType.equalsIgnoreCase("xml")?MediaType.APPLICATION_XML:MediaType.APPLICATION_JSON));
			HttpEntity<String> entity=new HttpEntity<>("body",headers);
			ResponseEntity<SpecialistsDetail[]> sp =restTemplate.exchange(uri,HttpMethod.GET,entity,SpecialistsDetail[].class);
			//String uri="http://localhost:8081/list/specialistsofhospital?hospitalId="+hospitalId+"&specialistType="+specialistType;
			SpecialistsDetail specialistDtls[] = sp.getBody();
			return Arrays.asList(specialistDtls);
		} catch (Exception e) {
			if(e instanceof HospitalFrontDeskException) {
				throw e;
			}else
				throw new Exception(e.getMessage());
			
		}
		
	}
	

}
