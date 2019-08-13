package fhir.administration.resources.datatypes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Period {
	
	private String start;
	private String end;
	
}
