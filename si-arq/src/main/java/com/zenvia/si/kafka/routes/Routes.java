package com.zenvia.si.kafka.routes;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zenvia.si.config.Config;
import com.zenvia.si.connectors.Consumer;
import com.zenvia.si.connectors.Producer;

@Component
public class Routes extends RouteBuilder {
	
	private Config config;
	
	private List<Consumer> consumerProcessors;
	private List<Producer> producerProcessors;
	private RoutesProcessor routeProcessor;
	
	@Autowired
	public Routes(Config config, RoutesProcessor routeProcessor, List<Consumer> consumerProcessors, List<Producer>producerProcessors) {
		this.config = config;
		this.routeProcessor = routeProcessor;
		this.consumerProcessors = consumerProcessors;
		this.producerProcessors = producerProcessors;
	}
	
    @Override
    public void configure() throws Exception {
    	
		for (Consumer consumer : consumerProcessors) {
			log.info(consumer.getTopic());
			
	    	String consumerURI = buildKafkaURI(consumer.getTopic(), Boolean.TRUE);
	    	
			from(consumerURI)
				.routeId(consumer.getId())
				.log(String.format("[CONSUMER][FROM:TOPIC:%s] Message: ${body}", consumer.getTopic()))
				.process(routeProcessor)
				.log(String.format("[CONSUMER][FROM:TOPIC:%s] Message: ${body} Process DONE.", consumer.getTopic()))
				.end();
				
		}
		
		for (Producer producer : producerProcessors) {
			String producerURI = buildKafkaURI(producer.getTopic(), Boolean.FALSE);
			
			from("direct:" + producer.getId())
		        .routeId(producer.getId())
		        .log(String.format("[PRODUCER - TO:TOPIC:%s] Sending: ${body}", producer.getTopic()))
		        .to(producerURI)
		        .log(String.format("[PRODUCER - TO:TOPIC:%s] DONE: ${body}", producer.getTopic()))
		        .end();
		}
		
    }
    
	private String buildKafkaURI(String topic, boolean isConsumer) {
		
		StringBuilder uri = new StringBuilder();
		uri.append("kafka");
		uri.append(":");
		uri.append(config.getKafkaServers());
		uri.append("?");
		uri.append("topic");
		uri.append("=");
		uri.append(topic);
		uri.append("&");
		uri.append("groupId");
		uri.append("=");
		uri.append(config.getApplicationSource());
		
//		if(isConsumer) {
//			uri = addGroupIdConfiguration(uri);
//		}
//		
		return uri.toString();
	}

	private StringBuilder addGroupIdConfiguration(StringBuilder uri) {
		
		
		return uri;
}
	
	public String buildKafkaURI(String topicName) {
		StringBuilder uri = new StringBuilder();
		uri.append("kafka");
		uri.append(":");
		uri.append(config.getKafkaServers());
		uri.append("?");
		uri.append("topic");
		uri.append("=");
		uri.append(topicName);
		return uri.toString();
	}

}
