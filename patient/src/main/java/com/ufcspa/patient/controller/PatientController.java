package com.ufcspa.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufcspa.patient.model.Patient;
import com.ufcspa.patient.service.PatientService;
import com.ufcspa.si.helper.JsonHelper;

@RestController
@RequestMapping("/Patient")
public class PatientController {
	
	@Autowired
	private JsonHelper jsonHelper;
	
	@Autowired
	private PatientService patientService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<String> findCustomer(@PathVariable String id) throws Exception {
		return new ResponseEntity<>(jsonHelper.toJson(""), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Patient> createCustomer(@RequestBody Patient patient) throws Exception {
		patient = patientService.save(patient);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}
	
}
