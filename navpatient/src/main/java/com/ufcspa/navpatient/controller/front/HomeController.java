package com.ufcspa.navpatient.controller.front;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufcspa.navpatient.controller.front.view.PatientViewData;
import com.ufcspa.navpatient.service.PatientService;
import com.ufcspa.navpatient.service.rest.response.PatientResponse;

import fhir.administration.resources.datatypes.HumanName;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public String home(Model model) {
		
		List<PatientResponse> searchPatient = patientService.searchPatient();
		List<PatientViewData> patientList = new ArrayList<PatientViewData>();
		
		for (PatientResponse patientResponse : searchPatient) {
			
			String name = buildPatientName(patientResponse.getName());
			
			PatientViewData patientDisplay = PatientViewData
					.builder()
						.name(name)
					.build();
			patientList.add(patientDisplay);
		}
		
		
		model.addAttribute("patientList", patientList);
		return "home.html";
	}

	private String buildPatientName(List<HumanName> names) {
		String name = "";
		for (HumanName humanName : names) {
			String given = "";
			for (String givenName : humanName.getGiven()) {
				given+=givenName;
			}
			name+=given;
		}
		return name;
	}


}
