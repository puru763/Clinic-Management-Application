package com.ClinicManagementApplication.patientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class PatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PatientServiceApplication.class);
		app.setAdditionalProfiles("debug");
		app.run(args);
	}
}