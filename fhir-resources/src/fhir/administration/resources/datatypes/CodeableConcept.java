package fhir.administration.resources.datatypes;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CodeableConcept {
	
	private List<Coding> coding;
	private String text;

}
