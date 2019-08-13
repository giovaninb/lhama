package com.ufcspa.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufcspa.si.helper.JsonHelper;

import fhir.administration.resources.Patient;

@RestController
@RequestMapping("patient")
public class PatientController {
	
	@Autowired
	private JsonHelper jsonHelper;
	
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<String> findCustomerByName() throws Exception {
		
		Patient patient = Patient.builder()
									.name("Thafarel")
								.build();
		
		return new ResponseEntity<>(jsonHelper.toJson(patient), HttpStatus.OK);
	}
	
}
