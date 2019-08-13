package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressTypeCode {
	
	POSTAL("home", "Home"),
	PHYSICAL("work", "Work"),
	BOTH("temp", "Temp");
	
	private String code;
	private String display;

}
