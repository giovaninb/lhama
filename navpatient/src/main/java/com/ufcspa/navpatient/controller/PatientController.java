package com.ufcspa.navpatient.controller;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ufcspa.navpatient.controller.view.NewPatientViewModel;
import com.ufcspa.navpatient.controller.view.PatientViewData;
import com.ufcspa.navpatient.service.PatientService;
import com.ufcspa.navpatient.service.rest.Patient;

import fhir.administration.resources.datatypes.HumanName;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/patient")
public class PatientController {

	private static final String NEW_PATIENT_VIEW_NAME = "newPatient.html";
	@Autowired
	private PatientService patientService;

	@RequestMapping("/new")
	public ModelAndView newPatient(ModelAndView model) {
		log.info("Entrou no método: newPatient");
		model.addObject("patient", new PatientViewData());
		model.setViewName(NEW_PATIENT_VIEW_NAME);
		return model;
	}
	
	/**
	 * Esse método vai receber os atributos montados na interface.
	 *
	 * @param viewModel
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@PostMapping("/new")
	public String saveNewPatient(@ModelAttribute PatientViewData viewModel) throws JsonProcessingException, IOException {
		
		Patient patient = fromNewPatientViewModelToPatient(viewModel);
		patientService.createNewPatient(patient);
		
		return "redirect:/patient/new";
	}
	
	/**
	 * Nesse método, tu precisa traduzir os dados que estão na interface para o teu objeto FHIR
	 * @param viewModel
	 * @return
	 */
	private Patient fromNewPatientViewModelToPatient(PatientViewData viewModel) {
		
		List<HumanName> name = buildHumanName(viewModel.getFirstName(), viewModel.getLastName());
		
		Patient patient = Patient
				.builder()
					.name(name)		
					.birthDate(viewModel.getBirthDate())
				.build();
		
		log.info("Informações do paciente: {} ", patient.toString());
		
		return patient;
	}

	/**
	 * Neste método tu precisa preencher os dados de campo do nome.
	 * Confirma se os dados chegaram até aqui através dos logs
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	private List<HumanName> buildHumanName(String firstName, String lastName) {
		
		
		HumanName humanName = HumanName
				.builder()
					.family(lastName)
					.given(Arrays.asList(firstName))
				.build();
		
		log.info("Detalhamento do HumanName: {} ", humanName);
		
		return Arrays.asList(humanName);
	}
	
}
