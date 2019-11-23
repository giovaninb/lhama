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

	@Autowired
	private PatientService patientService;

	@RequestMapping("/new")
	public String patient(Model model) {
		model.addAttribute("patient", new Patient());
		return "newPatient";
	}
	
//	public ModelAndView addNewPatient(ModelAndView model) throws JsonProcessingException, IOException {
//		NewPatientViewModel patient = new NewPatientViewModel();
//		model.addObject("patient", patient);
//		model.setViewName("newPatient");
//		return model;
//	}
	
	@PostMapping("/new")
	public String saveNewPatient(@ModelAttribute Patient patient) throws JsonProcessingException, IOException {
		
//		patientService.postPatient();
		
		return "/resultPatient";
	}
	
}
