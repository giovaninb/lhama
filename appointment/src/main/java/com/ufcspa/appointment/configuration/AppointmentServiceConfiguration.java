package com.ufcspa.appointment.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppointmentServiceConfiguration {

	@Value("${rest.hapifhir.base}}")
	private String baseHapifhir;
	
	@Value("${rest.hapifhir.appointment.resource}}")
	private String appointmentResource;
	
}
