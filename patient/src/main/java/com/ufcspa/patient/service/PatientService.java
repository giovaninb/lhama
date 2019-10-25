package com.ufcspa.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcspa.patient.connector.PatientSandboxConnector;
import com.ufcspa.patient.model.Patient;
import com.ufcspa.patient.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	PatientSandboxConnector patientSandboxConnector;
	
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public List<Patient> getPatients(){
		return patientSandboxConnector.getPatients();
	}

}
