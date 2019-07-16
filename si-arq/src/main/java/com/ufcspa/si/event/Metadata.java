package com.ufcspa.si.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Metadata {
	
	private String event;
	private String action;
	private String timestamp;
	private String applicationSource;
	
	

}
