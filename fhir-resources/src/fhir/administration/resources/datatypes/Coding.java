package fhir.administration.resources.datatypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coding {
	
	private String uri;
	private String version;
	private String code;
	private String display;
	private Boolean userSelected;

}
