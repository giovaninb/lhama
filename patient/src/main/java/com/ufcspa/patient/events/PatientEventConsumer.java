package com.ufcspa.patient.events;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientEventConsumer {
	
//	@KafkaListener(topics = "${kafka.patient.consumer.topic}", groupId = "${application.source}")
//	public void consumeEvent(String event) {
//		log.info("!!!> " + event);
//		
//	}
}
