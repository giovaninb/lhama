package com.ufcspa.patient.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class PatientServiceConfiguration {
	
	@Value("${rest.hapifhir.base}}")
	private String baseHapifhir;
	
	@Value("${rest.hapifhir.patient.resource}}")
	private String patientResource;
	
	@Value("${lhama.mode}}")
	private String lhamaMode;

}
