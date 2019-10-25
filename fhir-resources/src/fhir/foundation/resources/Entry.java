package fhir.foundation.resources;

import lombok.Data;

@Data
public class Entry {
	
	private String fullUrl;
	private Object resource;

}
