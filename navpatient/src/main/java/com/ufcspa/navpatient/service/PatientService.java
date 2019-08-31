package com.ufcspa.navpatient.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcspa.navpatient.configuration.Config;
import com.ufcspa.navpatient.service.rest.request.CustomerRequest;
import com.ufcspa.navpatient.service.rest.response.PatientResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientService {
	
	private Config config;
	private RestTemplate restTemplate;
	
	@Autowired
	public PatientService(RestTemplate restTemplate, Config config) {
		this.restTemplate = restTemplate;
		this.config = config;
	}
	
	public List<PatientResponse> searchPatient(){
		return searchPatient(null);
	}
	
	public List<PatientResponse> searchPatient(CustomerRequest customerRequest){
		
		UriComponentsBuilder uri = buildURICollector();
		
		return callPatientService(uri);
	}
	
	private List<PatientResponse> callPatientService(UriComponentsBuilder builder) {
		PatientResponse[] response = restTemplate.getForObject(builder.toUriString(), PatientResponse[].class);
		return Arrays.asList(response);
	}
	
	private UriComponentsBuilder buildURICollector() {
		UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(config.getCustomerHost())
                .path(config.getPatientSearchPath());
		
		log.info("Builded URI: {} ", builder.build().encode().toUri());
		
		return builder;
	}

}
