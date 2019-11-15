package com.ufcspa.appointment.model;

import fhir.administration.resources.datatypes.CodeableConcept;
import fhir.administration.resources.datatypes.Identifier;
import fhir.administration.resources.datatypes.Text;

import java.util.List;

import fhir.administration.resources.datatypes.AppointmentType;
import fhir.administration.resources.datatypes.ServiceType;
import fhir.administration.resources.datatypes.ReasonReference;
import fhir.administration.resources.datatypes.BasedOn;
import fhir.administration.resources.datatypes.Participant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

	@Builder .Default
	private String resourceType = "Appointment";
	private List<Identifier> identifier;
    private String id;
//    private List<Text> text;
    private String status;
//    private List<AppointmentType> serviceCategory;
//    private List<ServiceType> serviceType;
    private List<AppointmentType> specialty;
    private AppointmentType appointmentType;
//    private List<ReasonReference> reasonReference;
//    private long priority;
    private String description;
    private String start;
    private String end;
    private String created;
    private String comment;
//    private List<BasedOn> basedOn;
//    private List<Participant> participant;
}
