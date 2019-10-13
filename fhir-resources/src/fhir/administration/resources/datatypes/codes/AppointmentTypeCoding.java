package fhir.administration.resources.datatypes.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppointmentTypeCoding {
    
	CHECKUP("", "checkup", "A routine check-up, such as an annual physical"),
	EMERGENCY("", "emergency", "Emergency appointment"),
	FOLLOWUP("", "followup", "A follow up visit from a previous appointment"),
	ROUTINE("", "routine", "Routine appointment - default if not valued"),
	WALKIN("", "walkin", "A previously unscheduled walk-in visit");
	
	private String system;
    private String code;
    private String display;
    
}
