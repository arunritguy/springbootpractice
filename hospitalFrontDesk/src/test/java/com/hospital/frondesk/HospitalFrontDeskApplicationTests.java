package com.hospital.frondesk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.hospital.frontdesk.data.service.api.impl.HospitalFrontDeskServiceImpl;
import com.hospital.frontdesk.exception.HospitalFrontDeskException;
import com.hospital.frontdesk.model.SpecialistProperties;

@SpringBootTest(classes=HospitalFrontDeskApplicationTests.class)
//@RunWith(JUnitPlatform.class) --> Junit4
class HospitalFrontDeskApplicationTests {

	HospitalFrontDeskServiceImpl serviceImpl;
	SpecialistProperties specialistProp;
	
	@BeforeEach
	public void setupBefore() {
		serviceImpl= new HospitalFrontDeskServiceImpl();
		specialistProp = Mockito.mock(SpecialistProperties.class);
		ReflectionTestUtils.setField(serviceImpl,"specialistProp",specialistProp);
		Mockito.when(specialistProp.getName()).thenReturn(new String[] {"Karthik"});
		Mockito.when(specialistProp.getAvailableday()).thenReturn(new String[]{"Friday"});
		Mockito.when(specialistProp.getAvailabletime()).thenReturn(new String[] {"9-5"});
		ReflectionTestUtils.setField(serviceImpl, "name", "Junit Test Application");
		
	}
	
		
	/*
	 * @BeforeEach public void setup() {
	 * 
	 * 
	 * }
	 */
	
	@Test
	void verify_Specialist_List_For_A_Hospital_HospitalFrontDeskException_InvalidInput() {
		Assertions.assertThrows(HospitalFrontDeskException.class, ()->{
			serviceImpl.getSpecialistListForAHospital("946", "");
		}); 
	}
	
	@Test
	void verify_Specialist_Appointment_Invalid_Input() {
		Assertions.assertThrows(HospitalFrontDeskException.class,()->{
			serviceImpl.getSpecialistsAppointment(null, "","");
		});
	}
	
	@Test
	void verify_Specialist_Appointment_For_Valid_Data() {
		
		Assertions.assertNotNull(serviceImpl.getSpecialistsAppointment("Karthik", "Friday", "Vaishu"), "NO_Appointment");
	}
	
	
	@Test
	void verify_Name_Value() {
		Assertions.assertEquals("Junit Test Application", serviceImpl.getName());
	}

}
