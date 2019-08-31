package com.qad.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.qad.auth.intercepters.AuthIntercepter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	AuthIntercepter authIntercepter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authIntercepter)
		.addPathPatterns("/createTeam")
		.excludePathPatterns("/register", "/authenticate");
	}
}
