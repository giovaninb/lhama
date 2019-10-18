package com.ufcspa.patient.connector;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcspa.patient.configuration.PatientServiceConfiguration;
import com.ufcspa.patient.model.Patient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PatientSandboxConnector {
	
	@Autowired
	private PatientServiceConfiguration patientServiceConfiguration;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Patient> searchPatient(Patient patient){
		return callPatientService();
	}
	
	private List<Patient> callPatientService() {
		Patient response = restTemplate.getForObject(buildURICollector(), Patient.class);
		return Arrays.asList(response);
	}
	
	private String buildURICollector() {
		UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl("http://hapi.fhir.org/baseR4" + "/Patient/6?_format=json");
		
		log.info("Builded URI: {} ", builder.build().toUri());
		
		return builder.toUriString();
	}
	
	

}
