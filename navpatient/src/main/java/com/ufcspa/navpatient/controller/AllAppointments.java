package com.ufcspa.navpatient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ufcspa.navpatient.controller.view.AppointmentViewData;

import com.ufcspa.navpatient.service.AppointmentService;
import com.ufcspa.navpatient.service.rest.Appointment;

import fhir.administration.resources.datatypes.Text;

@Controller
@RequestMapping("/allAppointments")
public class AllAppointments {
	
	public static final String HOME_VIEW = "allAppointment";
	
	@Autowired
	private AppointmentService appointmentService;
	
	@GetMapping
	public ModelAndView allAppointments(ModelAndView model) {
		
		List<Appointment> searchAppointment = appointmentService.getAppointments();
		List<AppointmentViewData> appointmentList = new ArrayList<AppointmentViewData>();
		
		for (Appointment appointmentResponse : searchAppointment) {
			String description = " ";
			if(appointmentResponse.getText() != null) {
				description = String.valueOf(appointmentResponse.getText());
			}
			
			AppointmentViewData appointmentDisplay = AppointmentViewData.builder()
						.description(description)
					.build();
			if (!description.isEmpty()) {
				appointmentList.add(appointmentDisplay);
			}
		}
		
		model.addObject("appointmentList", appointmentList);
		model.setViewName(HOME_VIEW);
		return model;	
	}

}
