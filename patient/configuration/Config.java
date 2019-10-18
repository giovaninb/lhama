package com.ufcspa.navpatient.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class Config {
	
	@Value("${rest.customer.host}}")
	private String customerHost;
	
	@Value("${rest.customer.search}}")
	private String patientSearchPath;

}
