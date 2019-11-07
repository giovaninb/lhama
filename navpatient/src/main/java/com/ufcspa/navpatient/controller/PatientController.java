package com.ufcspa.navpatient.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ufcspa.navpatient.service.PatientService;


import fhir.administration.resources.datatypes.HumanName;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	@RequestMapping("/new")
	public String addNewPatient() throws JsonProcessingException, IOException {
		
		patientService.postPatient();
		
		return "newPatient";
	}
	
	private String buildPatientName(List<HumanName> names) {
		String name = "";
		
		for (HumanName humanName : names) {
				String given = "";
				for (String givenName : humanName.getGiven()) {
					given+=givenName;
				}
				name+= " " + given;
		}
		return name;
	}

    

}
