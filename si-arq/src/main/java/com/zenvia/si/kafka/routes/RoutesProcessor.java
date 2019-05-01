package com.zenvia.si.kafka.routes;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zenvia.si.config.Config;
import com.zenvia.si.connectors.Consumer;
import com.zenvia.si.event.Metadata;
import com.zenvia.si.helper.JsonHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RoutesProcessor  implements Processor {
	
	private Config config;
	private JsonHelper jsonHelper;
	
    private List<Consumer> eventProcessors;
	
    @Autowired
	public RoutesProcessor(Config config, JsonHelper jsonHelper, List<Consumer> beanList) {
    	this.config = config;
		this.jsonHelper = jsonHelper;
		this.eventProcessors = beanList;
	}
	
	@Override
	public void process(Exchange exchange) throws Exception {
		String body = (String) exchange.getIn().getBody();
		Metadata metadata = jsonHelper.fromJson(body, Metadata.class);
		
		log.info("[METADATA] {} ", metadata);
		
		if(!streamProducedFromSameSource(metadata)) {
			
			// [Thafarel] Maybe in the future we need to improve that... but, for now its ok.
			for (Consumer consumer : eventProcessors) {
				
				if(consumer.getEvent().equalsIgnoreCase(metadata.getEvent())) {
					consumer.process(metadata, body);
					
				}
			}
			
		} else {
			log.info("Stream not accepted {} for APP {}", metadata, config.getApplicationSource());
		}
		
	}

	private boolean streamProducedFromSameSource(Metadata metadata) {
		return !config.getApplicationSource().equals(metadata.getApplicationSource());
	}

}
