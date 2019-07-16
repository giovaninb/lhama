package com.ufcspa.si.connectors;

import com.ufcspa.si.event.Metadata;

public interface Consumer {
	
	public void process(Metadata metadata, String body);
	
	public String getTopic();
	public String getEvent();
	public String getId();
	
}
