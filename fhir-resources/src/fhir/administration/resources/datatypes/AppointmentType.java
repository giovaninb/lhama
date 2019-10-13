package fhir.administration.resources.datatypes;

import java.util.List;

import fhir.administration.resources.datatypes.codes.AppointmentTypeCoding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentType {
    private List<AppointmentTypeCoding> coding;

}
