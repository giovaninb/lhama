package com.ufcspa.appointment.connector;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufcspa.appointment.configuration.AppointmentServiceConfiguration;
import com.ufcspa.appointment.model.Appointment;

import fhir.foundation.resources.Bundle;
import fhir.foundation.resources.Entry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppointmentSandboxConnector {
	
	@Autowired
	private AppointmentServiceConfiguration appointmentSandboxConnector;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Appointment> getAllAppointments() {
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		Bundle response = restTemplate.getForObject(buildURIAppointmentList(), Bundle.class);
		for (Entry entry : response.getEntry()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Appointment appointment = mapper.convertValue(entry.getResource(), Appointment.class);
			appointmentList.add(appointment);
		}
		return appointmentList;
	}
	
	private String buildURIAppointmentList() {
		StringBuffer uri = new StringBuffer("http://hapi.fhir.org/baseR4");
		uri.append("/Appointment/");
//		uri.append(6);	
		uri.append("?_format=json");
		
		UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(uri.toString());
		
		log.info("Builded URI: {} ", builder.build().toUri());
		
		return builder.toUriString();
	}
	

}
