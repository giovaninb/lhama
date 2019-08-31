package com.ufcspa.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcspa.patient.model.Patient;
import com.ufcspa.patient.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

}
