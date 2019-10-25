package fhir.administration.resources.datatypes;

import java.util.List;

import fhir.administration.resources.datatypes.codes.AddressUseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private AddressUseCode use; // home | work | temp | old | billing - purpose of this address
	private String type; // postal | physical | both
	private String text; // Text representation of the address
	private List<String> line; // direction & P.O. Box etc.
	private String city; // town etc.
	private String district; // District name (aka county)
	private String state; // Sub-unit of country (abbreviations ok)
	private String postalCode; // Postal code for area
	private String country; // Country (e.g. can be ISO 3166 2 or 3 letter code)
	
}
