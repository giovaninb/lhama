package com.ufcspa.navpatient.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class HomeController {
	
	@GetMapping
	public String novo() {
		return "home";
	}

}
