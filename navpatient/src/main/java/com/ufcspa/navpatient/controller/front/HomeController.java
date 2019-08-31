package com.ufcspa.navpatient.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("/home")
	public String novo() {
		return "home";
	}

}
