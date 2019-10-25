package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum IdentifierUseCode {
	
	use("use", "Use"),
	usual("usual", "Usual"),
	official("official", "Official"),
	temp("temp", "Temp"),
	secondary("secondary", "Secondary"),
	old("old", "Old");
	
	private String code;
	private String display;

}
