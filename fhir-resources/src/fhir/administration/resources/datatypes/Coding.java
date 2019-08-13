package fhir.administration.resources.datatypes;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Coding {
	
	private String uri;
	private String version;
	private String code;
	private String display;
	private Boolean userSelected;

}
