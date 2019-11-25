package com.ufcspa.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@PostMapping("/new")
	public ResponseEntity<Patient> createPatient(Patient patient) {
		patientService.createPatientOnHaPI(patient);
		return new ResponseEntity<Patient>(patient, HttpStatus.CREATED);
	}
}
