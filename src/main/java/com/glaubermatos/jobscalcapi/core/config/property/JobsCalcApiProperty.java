package com.glaubermatos.jobscalcapi.core.config.property;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jobscalc")
public class JobsCalcApiProperty {

	private List<String> allowedOrigins;

	public List<String> getAllowedOrigins() {
		return allowedOrigins;
	}

	public void setAllowedOrigins(List<String> allowedOrigins) {
		this.allowedOrigins = allowedOrigins;
	}

	
	
}
