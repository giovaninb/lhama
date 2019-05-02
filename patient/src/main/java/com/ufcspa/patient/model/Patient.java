package com.ufcspa.patient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	
	@Builder.Default
	private String resourceType = "Patient";
	 
	private String identifier;
	private boolean active;
	private String name;

}
