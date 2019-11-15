package com.ufcspa.navpatient.service;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcspa.navpatient.configuration.Config;
import com.ufcspa.navpatient.service.rest.Appointment;
import com.ufcspa.navpatient.service.rest.Patient;

@Service
public class AppointmentService {

	@Autowired
	private Config config;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Appointment> getAppointments() {
		
		UriComponentsBuilder uri = buildURICollector();
		return callGetAppointments(uri);
		
	}
	
	
	private List<Appointment> callGetAppointments(UriComponentsBuilder builder) {
		Appointment[] response = restTemplate.getForObject(builder.toUriString(), Appointment[].class);
		return Arrays.asList(response);
	}	
	
	
	private UriComponentsBuilder buildURICollector() {
		UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(config.getAppointmentHost())
                .path(config.getAppointmentListPath());
		
		return builder;
	}

	
}
