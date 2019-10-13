package com.ufcspa.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcspa.appointment.model.Appointment;
import com.ufcspa.appointment.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

}
