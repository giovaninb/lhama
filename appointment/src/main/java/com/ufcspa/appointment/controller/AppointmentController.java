package com.ufcspa.appointment.controller;

import java.util.List;

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

@RestController
@RequestMapping("/Appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Appointment>> listAppointments() throws Exception {
		return new ResponseEntity<>(appointmentService.getAppointments(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Appointment> createCustomer(@RequestBody Appointment appointment) throws Exception {
		appointment = appointmentService.save(appointment);
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}

}
