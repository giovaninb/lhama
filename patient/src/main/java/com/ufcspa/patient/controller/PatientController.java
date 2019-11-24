package com.ufcspa.patient.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import com.ufcspa.patient.connector.PatientSandboxConnector;
import com.ufcspa.patient.model.Patient;
import com.ufcspa.patient.service.PatientService;

@RestController
@RequestMapping("/Patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Patient>> listPatients() throws Exception {
		return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<List<Patient>> createPatient() throws URISyntaxException {
		URI uri = new URI("http://hapi.fhir.org/baseR4/Patient");
		RequestEntity<Patient> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(patientService.saveUpdatePatient());
		return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
	}
	
}
