package fhir.administration.resources;

import java.util.List;

import fhir.administration.resources.datatypes.Address;
import fhir.administration.resources.datatypes.HumanName;
import fhir.administration.resources.datatypes.Identifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	
	@Builder.Default
	private String resourceType = "Patient";
	 
	private Identifier identifier;
	private boolean active;
	private List<HumanName> name;
	private String birthDate;
	private Address address;

}
