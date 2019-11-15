package com.ufcspa.patient.events;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientEventProducer {
	
//	@Autowired
//	private KafkaTemplate<String,String> kafkaTemplate;
//	
//	public void send(String event) {
//		log.info("---> " + event);
//		this.kafkaTemplate.send("patient","oi thafarel");
//	}
}
