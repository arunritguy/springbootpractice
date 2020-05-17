package com.hospital.specialist.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HospitalSpecialistDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalSpecialistDetailsApplication.class, args);
	}

}
