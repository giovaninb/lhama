package com.ufcspa.navpatient.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ufcspa.navpatient.controller.view.NewPatientViewModel;
import com.ufcspa.navpatient.service.PatientService;
import com.ufcspa.navpatient.service.rest.Patient;

@Controller
@RequestMapping("/patient")
public class PatientController {

	private static final String NEW_PATIENT_VIEW_NAME = "newPatient.html";
	@Autowired
	private PatientService patientService;

	@RequestMapping("/new")
	public ModelAndView patient(ModelAndView model) {
		model.addObject("patient", new NewPatientViewModel());
		model.setViewName(NEW_PATIENT_VIEW_NAME);
		return model;
	}
	
	@PostMapping("/new")
	public String saveNewPatient(@ModelAttribute Patient patient) throws JsonProcessingException, IOException {
		
//		patientService.postPatient();
		
		return "/resultPatient";
	}
	
}
