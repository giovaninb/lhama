package com.zenvia.si.service;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zenvia.si.config.Config;
import com.zenvia.si.event.EventStream;
import com.zenvia.si.event.Metadata;
import com.zenvia.si.helper.DateTimeHelper;
import com.zenvia.si.helper.JsonHelper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaService {
	
	private Config config;
	private JsonHelper jsonHelper;
	private ProducerTemplate producerTemplate;
	
	@Autowired
	public KafkaService(Config config, JsonHelper jsonHelper, ProducerTemplate producerTemplate) {
		this.config = config;
		this.jsonHelper = jsonHelper;
		this.producerTemplate = producerTemplate;
	}

	public void send(Object content, String route, String event, String action) {
		log.info("Preparing Stream...");
		
		Metadata metadata = buidMetadata(event, action);
		EventStream stream = buildEventStream(content, metadata);
		
		sendStream(stream, route);
		
	}
	
	private void sendStream(EventStream event, String route) {
		log.info("[SEND TO KAFKA] Creating Stream...");
		
		String json = jsonHelper.toJson(event);
		
		log.info("[SENDING TO KAFKA] Route: {} , Stream: {} ", route, json);
		
		producerTemplate.sendBody(("direct:" + route), json);
	}

	private EventStream buildEventStream(Object content, Metadata metadata) {
		EventStream event = EventStream
				.builder()
					.metadata(metadata)
					.content(content)
				.build();
		return event;
	}

	private Metadata buidMetadata(String event, String action) {
		Metadata metadata = Metadata
				.builder()
					.event(event)
					.action(action)
					.timestamp(DateTimeHelper.getNow())
					.applicationSource(config.getApplicationSource())
				.build();
		return metadata;
	}

}
