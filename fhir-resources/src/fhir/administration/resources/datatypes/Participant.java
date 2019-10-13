package fhir.administration.resources.datatypes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    private ReasonReference actor;
    private String required;
    private String status;
    private List<Type> type;
}