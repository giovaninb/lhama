package com.zenvia.si.connectors;

import com.zenvia.si.event.Metadata;

public interface Consumer {
	
	public void process(Metadata metadata, String body);
	
	public String getTopic();
	public String getEvent();
	public String getId();
	
}
