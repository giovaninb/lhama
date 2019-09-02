package com.ufcspa.navpatient.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufcspa.navpatient.service.PatientService;
import com.ufcspa.navpatient.service.rest.response.PatientResponse;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping("/home")
	public String home() {
		
//		List<PatientResponse> searchPatient = patientService.searchPatient();
		
		
		return "home";
	}

}
