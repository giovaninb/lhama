package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressUseCode {
	
	HOME("home", "Home"),
	WORK("work", "Work"),
	TEMP("temp", "Temp"),
	OLD("old", "Old"),
	BILLING("billing", "Billing");
	
	private String code;
	private String display;

}
