package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HumanNameUseCode {
	
	USUAL("usual", "Usual", "The identifier recommended for display and use in real-world interactions."),
	OFFICIAL("official", "Official", "The identifier considered to be most trusted for the identification of this item. Sometimes also known as \"primary\" and \"main\". The determination of \"official\" is subjective and implementation guides often provide additional guidelines for use."),
	TEMP("temp", "Temp","A temporary identifier."),
	SECONDARY("secondary", "Secondary", "An identifier that was assigned in secondary use - it serves to identify the object in a relative context, but cannot be consistently assigned to the same object again in a different context."),
	OLD("old", "Old", "The identifier id no longer considered valid, but may be relevant for search purposes. E.g. Changes to identifier schemes, account merges, etc.");
	
	private String display;
	private String code;
	private String definition;

}
