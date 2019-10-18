package fhir.administration.resources.datatypes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeableConcept {
	
	private List<Coding> coding;
	private String text;

}
