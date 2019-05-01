package com.zenvia.si.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class Config {
	
	@Value("${application.source}")
    public String applicationSource;
	
	@Value("${conf.kafka.servers}")
	private String kafkaServers;
	
}
