package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressUseCode {
	
	home("home", "Home"),
	work("work", "Work"),
	temp("temp", "Temp"),
	old("old", "Old"),
	billing("billing", "Billing");
	
	private String code;
	private String display;

}
