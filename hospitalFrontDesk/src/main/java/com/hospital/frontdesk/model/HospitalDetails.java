package com.hospital.frontdesk.model;

import java.util.List;

public class HospitalDetails {

	private String hospitalName;
	private Integer bedCount;
	private List<HospitalBedDetail> bedDetailsList;

	public static class HospitalBedDetail {

		private Integer bedNo;
		private String patientStatus;

		public HospitalBedDetail(Integer bedNo, String patientStatus) {
			super();
			this.bedNo = bedNo;
			this.patientStatus = patientStatus;
		}

		public String getPatientStatus() {
			return patientStatus;
		}

		public void setPatientStatus(String patientStatus) {
			this.patientStatus = patientStatus;
		}

		public Integer getBedNo() {
			return bedNo;
		}

		public void setBedNo(Integer bedNo) {
			this.bedNo = bedNo;
		}

	}

	public HospitalDetails(String hospitalName, Integer bedCount, List<HospitalBedDetail> bedDetailsList) {
		super();
		this.hospitalName = hospitalName;
		this.bedCount = bedCount;
		this.bedDetailsList = bedDetailsList;
	}

	public HospitalDetails(String hospitalName, Integer bedCount) {
		super();
		this.hospitalName = hospitalName;
		this.bedCount = bedCount;
	}

	public List<HospitalBedDetail> getBedDetailsList() {
		return bedDetailsList;
	}

	public void setBedDetailsList(List<HospitalBedDetail> bedDetailsList) {
		this.bedDetailsList = bedDetailsList;
	}

	public Integer getBedCount() {
		return bedCount;
	}

	public void setBedCount(Integer bedCount) {
		this.bedCount = bedCount;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}
