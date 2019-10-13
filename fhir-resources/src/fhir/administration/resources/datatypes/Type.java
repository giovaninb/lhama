package fhir.administration.resources.datatypes;

import java.util.List;

import fhir.administration.resources.datatypes.codes.TypeCoding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Type {
	private List<TypeCoding> coding;

}
