package fhir.administration.resources.datatypes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReasonReference {
    private String reference;
    private String display;

}
