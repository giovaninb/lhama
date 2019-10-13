package fhir.administration.resources.datatypes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Text {
	
	private String status;
    private String div;

}
