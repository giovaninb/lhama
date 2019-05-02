package com.ufcspa.patient.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufcspa.helper.JsonHelper;
import com.ufcspa.patient.model.Patient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/patient")
public class PacientController {
	
	private JsonHelper jsonHelper;
	
	@Autowired
	public PacientController(JsonHelper jsonHelper) {
		this.jsonHelper = jsonHelper;
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<String> findCustomerByName(@PathParam("name") String name) throws Exception {
		
		log.info("Patient name: {} ", name);
		
		Patient patient = Patient.builder()
									.name(name)
								.build();
		
		log.info("Patient data: {} ", patient);
		
		return new ResponseEntity<>(jsonHelper.toJson(patient), HttpStatus.OK);
	}
	
}
