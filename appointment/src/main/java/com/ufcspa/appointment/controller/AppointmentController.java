package com.ufcspa.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufcspa.appointment.model.Appointment;
import com.ufcspa.appointment.service.AppointmentService;
import com.ufcspa.si.helper.JsonHelper;

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {

	@Autowired
	private JsonHelper jsonHelper;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<String> findCustomer(@PathVariable String id) throws Exception {
		return new ResponseEntity<>(jsonHelper.toJson(""), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Appointment> createCustomer(@RequestBody Appointment appointment) throws Exception {
		appointment = appointmentService.save(appointment);
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

}
