package com.qad.auth.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LogManager.getLogger(AppSecurityConfig.class);
	
	@Autowired
	AppUserDetailsService userDetailsService;

	@Autowired
	JwtAuthenticationProvider jwtAuthenticationProvider;
	
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private AuthFilter authFilter;
	
	// @Autowired
	// private AuthFilter jwtRequestFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOGGER.info("initiating security config ...");
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// http.csrf().disable().authorizeRequests().antMatchers("/authenticate", "/register").permitAll().anyRequest().authenticated();
		http.csrf().disable().authorizeRequests().antMatchers("*").permitAll();
		http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
		// Add a filter to validate the tokens with every request
		http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
