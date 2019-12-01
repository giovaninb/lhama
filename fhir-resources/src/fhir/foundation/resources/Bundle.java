package fhir.foundation.resources;

import java.util.List;
import lombok.Data;

@Data
public class Bundle {
	
	private String resourceType;
	private String type;
	public List<Entry> entry;
	
}






