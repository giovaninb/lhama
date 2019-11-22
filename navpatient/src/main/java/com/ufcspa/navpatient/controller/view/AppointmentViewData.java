package com.ufcspa.navpatient.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentViewData {
	
	private String description;
	private String start;
	private String end;
	private String status;
	private String id;

}
