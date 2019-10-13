package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceTypeCoding {
	
	// TODO Insert all codes: https://www.hl7.org/fhir/codesystem-service-type.html
	
	MEDICAL_ONCOLOGY("175", "Medical Oncology"),
	GYNAECOLOGICAL_ONCOLOGY("185", "Gynaecological Oncology"),
	PAEDIATRIC_MEDICAL_ONCOLOGY("199", "Paediatric Medical Oncology"),
	RADIATION_ONCOLOGY("214", "Radiation oncology");
	
    private String code;
    private String display;

}