package com.ufcspa.navpatient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	
	@RequestMapping("/new")
	public String appointment() {
		
		return "newAppointment";
	}

}
