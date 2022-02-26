package com.glaubermatos.jobscalcapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.glaubermatos.jobscalcapi.core.config.property.JobsCalcApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(JobsCalcApiProperty.class)
public class JobscalcApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobscalcApiApplication.class, args);
	}

}
