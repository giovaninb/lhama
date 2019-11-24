package com.ufcspa.patient.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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
	
	@PostMapping
	public ResponseEntity<Patient> createPatient() {
//		return new RequestEntity<>(patientService.saveUpdatePatient(), HttpMethod.POST);
		return new ResponseEntity<>(patientService.saveUpdatePatient(), HttpStatus.OK);
	}
	
}
