package fhir.administration.resources.datatypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasedOn {
    private String reference;	

}
