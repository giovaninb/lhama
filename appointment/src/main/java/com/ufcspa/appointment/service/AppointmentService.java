package com.ufcspa.appointment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcspa.appointment.connector.AppointmentSandboxConnector;
import com.ufcspa.appointment.model.Appointment;
import com.ufcspa.appointment.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	AppointmentSandboxConnector appointmentSandboxConnector;
	
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	public List<Appointment> getAppointments() {
		return appointmentSandboxConnector.getAllAppointments();
	}

}
