package com.ufcspa.si.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventStream {
	
	private Metadata metadata;
	private Object content;
	
}
