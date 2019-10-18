package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum IdentifierUseCode {
	
	USUAL("usual", "Usual"),
	OFFICIAL("official", "Official"),
	TEMP("temp", "Temp"),
	SECONDARY("secondary", "Secondary"),
	OLD("old", "Old");
	
	private String code;
	private String display;

}
