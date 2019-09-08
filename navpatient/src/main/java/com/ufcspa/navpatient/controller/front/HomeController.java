package com.ufcspa.navpatient.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ufcspa.navpatient.service.PatientService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public String home() {
		
//		List<PatientResponse> searchPatient = patientService.searchPatient();
		
		
		return "home";
	}

}
