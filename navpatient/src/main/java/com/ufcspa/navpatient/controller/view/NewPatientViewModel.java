package com.ufcspa.navpatient.controller.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewPatientViewModel {
	
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;

}
