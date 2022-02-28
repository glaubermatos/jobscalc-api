package com.glaubermatos.jobscalcapi.core.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.glaubermatos.jobscalcapi.core.config.property.JobsCalcApiProperty;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JobsCalcApiProperty jobsCalcApiProperty;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// H2
		if (Arrays.asList(env.getActiveProfiles()).contains("dev")) {
			http.headers().frameOptions().disable();
		}
					
		http
			.cors()
			
			.and()
				.httpBasic()
				
			.and()
				.authorizeRequests()
//					.antMatchers("/path/**").permitAll() //para end-points públicos
					.anyRequest().authenticated()
					
			.and()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					
			.and()
				.csrf().disable();
	}
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(true);
		corsConfig.addAllowedHeader("*");
		corsConfig.addAllowedMethod("*");
		corsConfig.setMaxAge(3600L);
		corsConfig.setAllowedOrigins(jobsCalcApiProperty.getAllowedOrigins());
//		corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		
		return new CorsFilter(source);
	}

}
