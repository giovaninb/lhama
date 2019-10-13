package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeCoding {

	// TODO Refactor to real codes
	EXAMPLE("http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "ATND");
	
	private String system;
    private String code;

}
