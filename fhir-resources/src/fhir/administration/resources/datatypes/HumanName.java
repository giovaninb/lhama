package fhir.administration.resources.datatypes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HumanName {
	
	private String use;
	private String text;
	private String family;
	private List<String> given;
	private String prefix;
	private String suffix;
	private String period;

}
