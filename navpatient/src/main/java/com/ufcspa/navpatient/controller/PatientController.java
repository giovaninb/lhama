package com.ufcspa.navpatient.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ufcspa.navpatient.controller.view.NewPatientViewModel;
import com.ufcspa.navpatient.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping("/new")
	public ModelAndView addNewPatient(ModelAndView model) throws JsonProcessingException, IOException {
		NewPatientViewModel patient = new NewPatientViewModel();
		model.addObject("patient", patient);
		model.setViewName("newPatient");
		return model;
	}
	
	@PostMapping
	public String saveNewPatient() throws JsonProcessingException, IOException {
		
//		patientService.postPatient();
		
		return "/home";
	}
	
}
