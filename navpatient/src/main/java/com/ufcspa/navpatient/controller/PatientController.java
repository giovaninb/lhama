package com.ufcspa.navpatient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ufcspa.navpatient.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@RequestMapping("/new")
	public String home() {


//		List<PatientResponse> searchPatient = patientService.searchPatient();
		return "novoPaciente";
	}

}
