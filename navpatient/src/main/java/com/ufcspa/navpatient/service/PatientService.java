package com.ufcspa.navpatient.service;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ufcspa.navpatient.configuration.Config;
import com.ufcspa.navpatient.service.rest.Patient;

import fhir.administration.resources.datatypes.HumanName;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientService {
	
	@Autowired
	private Config config;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Patient> getPatients(){
		
		UriComponentsBuilder uri = buildURICollector();
		
		return callGetPatients(uri);
	}
	
	public String postPatient() throws JsonProcessingException, IOException {
		UriComponentsBuilder uri = buildURICollector();
		return savePatient(uri);
	}
	
	public String savePatient(UriComponentsBuilder builder) throws JsonProcessingException, IOException {
		
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		httpHeaders.set("Content-Type", "application/json");
		
		RestTemplate restTemplate = new RestTemplate();

		// Não sei se devo terminar de colocar os dados aqui
		Patient patient = new Patient();
        patient.setBirthDate("1996-11-05");
        ObjectMapper mapper = new ObjectMapper();

        HttpEntity<String> request = new HttpEntity<>(mapper.writeValueAsString(patient), httpHeaders);

        String response = restTemplate.postForObject(builder.toUriString(), request, String.class);

        log.info("Json:{} ", response);
        
        return response;
		
	}
	
	private List<Patient> callGetPatients(UriComponentsBuilder builder) {
		Patient[] response = restTemplate.getForObject(builder.toUriString(), Patient[].class);
		return Arrays.asList(response);
	}	

	private UriComponentsBuilder buildURICollector() {
		UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(config.getPatientHost())
                .path(config.getPatientListPath());
		
		log.info("Builded URI: {} ", builder.build().encode().toUri());
		
		return builder;
	}

}
