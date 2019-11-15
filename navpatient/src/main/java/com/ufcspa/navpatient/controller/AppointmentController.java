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

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	public static final String APPOINTMENT_VIEW = "allAppointment";

	@Autowired
	private AppointmentService appointmentService;

	@RequestMapping("/new")
	public String appointment() {

		return "newAppointment";
	}

	@RequestMapping("/allAppointment")
	public ModelAndView allAppointments(ModelAndView model) {

		List<Appointment> searchAppointment = appointmentService.getAppointments();
		List<AppointmentViewData> appointmentList = new ArrayList<AppointmentViewData>();

		for (Appointment appointmentResponse : searchAppointment) {

			if (appointmentResponse.getDescription() != null 
					&& !appointmentResponse.getDescription().isEmpty()) {

				AppointmentViewData appointmentDisplay = AppointmentViewData
						.builder()
							.description(appointmentResponse.getDescription())
						.build();
				
				appointmentList.add(appointmentDisplay);
			}

		}

		model.addObject("appointmentList", appointmentList);
		model.setViewName(APPOINTMENT_VIEW);
		return model;
	}

}
