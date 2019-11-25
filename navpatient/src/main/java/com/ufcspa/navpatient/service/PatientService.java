package com.ufcspa.navpatient.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufcspa.navpatient.configuration.Config;
import com.ufcspa.navpatient.service.rest.Patient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientService {

	@Autowired
	private Config config;

	@Autowired
	private RestTemplate restTemplate;

	public List<Patient> getPatients() {

		UriComponentsBuilder uri = buildURICollector();

		return callGetPatients(uri);
	}

	private List<Patient> callGetPatients(UriComponentsBuilder builder) {
		Patient[] response = restTemplate.getForObject(builder.toUriString(), Patient[].class);
		return Arrays.asList(response);
	}

	private UriComponentsBuilder buildURICollector() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getPatientHost())
				.path(config.getPatientListPath());

		log.info("Builded URI: {} ", builder.build().encode().toUri());

		return builder;
	}

	/**
	 * Aqui tu vai fazer uma chamada post para o método createPatient que vai estar
	 * na controller do microsservico patient
	 * (https://www.baeldung.com/spring-resttemplate-post-json)
	 * 
	 * @param patient
	 */
	public void createNewPatient(Patient patient) {
		log.info("dados");
		
		String uri = config.getPatientHost() + "/Patient/new";
		Patient patientResponse = restTemplate.postForObject(uri, patient, Patient.class);
		
		log.info(patientResponse.toString());
	}

}
