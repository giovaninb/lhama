package com.ufcspa.navpatient.controller.front.view;

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
	private String identifier;

}
