package com.ufcspa.navpatient.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class Config {
	
	@Value("${rest.patient.host}")
	private String patientHost;
	
	@Value("${rest.patient.list}")
	private String patientListPath;
	
	@Value("${rest.appointment.host}")
	private String appointmentHost;
	
	@Value("${rest.appointment.list}")
	private String appointmentListPath;
	
}
