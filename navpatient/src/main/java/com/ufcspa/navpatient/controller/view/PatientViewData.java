package com.ufcspa.navpatient.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientViewData {
	
	private String name;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String gender;
	private String id;

}
