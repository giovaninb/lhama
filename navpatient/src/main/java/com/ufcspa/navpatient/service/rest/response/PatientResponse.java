package com.ufcspa.navpatient.service.rest.response;

import java.util.List;

import fhir.administration.resources.datatypes.Address;
import fhir.administration.resources.datatypes.HumanName;
import fhir.administration.resources.datatypes.Identifier;

public class PatientResponse {
	
	private Identifier identifier;
	private boolean active;
	private List<HumanName> name;
	private String birthDate;
	private Address address;

}
