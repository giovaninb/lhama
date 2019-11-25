package com.ufcspa.patient.connector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufcspa.patient.configuration.PatientServiceConfiguration;
import com.ufcspa.patient.model.Patient;

import fhir.foundation.resources.Bundle;
import fhir.foundation.resources.Entry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PatientSandboxConnector {

	@Autowired
	private PatientServiceConfiguration patientServiceConfiguration;

	@Autowired
	private RestTemplate restTemplate;

	public List<Patient> getPatients() {
		List<Patient> patientList = new ArrayList<Patient>();
		Bundle response = restTemplate.getForObject(buildURIPatient(), Bundle.class);
		for (Entry entry : response.getEntry()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Patient patient = mapper.convertValue(entry.getResource(), Patient.class);
			patientList.add(patient);
		}
		return patientList;
	}

	public Patient createPatient() {
		Patient patient = new Patient();
		patient.setResourceType("Patient");

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/fhir+json;charset=utf-8");

		HttpEntity<Patient> requestObj = new HttpEntity<>(patient, headers);

		Bundle request = restTemplate.postForObject(buildURIPatient(), requestObj, Bundle.class);
		for (Entry entry : request.getEntry()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			patient = mapper.convertValue(entry.getResource(), Patient.class);
		}
		log.info("Builded Body: {} ", patient);
		return patient;
	}

	public String buildURIPatient() {
		StringBuffer uri = new StringBuffer("http://hapi.fhir.org/baseR4");
		uri.append("/Patient/");
		uri.append("?_format=json");

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri.toString());

		log.info("Builded URI: {} ", builder.build().toUri());

		return builder.toUriString();
	}

	public Patient createPatientOnHaPI(Patient patient) {

		ObjectMapper om = new ObjectMapper();

		String json;
		try {
			json = om.writeValueAsString(patient);

			restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<String>(json, headers);

			String uri = "http://hapi.fhir.org/baseR4/Patient";

			Patient patientResponse = restTemplate.postForObject(uri, request, Patient.class);
			
			return patientResponse;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;

	}

}
