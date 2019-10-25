package com.ufcspa.navpatient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufcspa.navpatient.controller.view.PatientViewData;
import com.ufcspa.navpatient.service.PatientService;
import com.ufcspa.navpatient.service.rest.response.Patient;

import fhir.administration.resources.datatypes.HumanName;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	public static final String HOME_VIEW = "home";
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping
	public ModelAndView home(ModelAndView model) {
		
		List<Patient> searchPatient = patientService.getPatients();
		List<PatientViewData> patientList = new ArrayList<PatientViewData>();
		
		for (Patient patientResponse : searchPatient) {
			String name = "";
			if(patientResponse.getName() != null) {
				name = buildPatientName(patientResponse.getName());
			}
			
			PatientViewData patientDisplay = PatientViewData
					.builder()
						.name(name)
					.build();
			patientList.add(patientDisplay);
		}
		
		model.addObject("patientList", patientList);
		model.setViewName(HOME_VIEW);
		return model;
	}

	private String buildPatientName(List<HumanName> names) {
		String name = "";
		
		for (HumanName humanName : names) {
				String given = "";
				for (String givenName : humanName.getGiven()) {
					given+=givenName;
				}
				name+= " " + given;
		}
		return name;
	}

}
