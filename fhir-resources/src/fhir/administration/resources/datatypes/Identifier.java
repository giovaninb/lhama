package fhir.administration.resources.datatypes;

import fhir.administration.resources.datatypes.codes.IdentifierUseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Identifier {
	
	private IdentifierUseCode use;
	private CodeableConcept type;
	private String system;
	private Period period;
	
}
