package com.qad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qad.delegate.IAuthDelegate;
import com.qad.model.Credentials;
import com.qad.model.JwtToken;

@RestController
public class AuthController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private IAuthDelegate authDelegate;

	@PostMapping(value = "/authenticate")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public JwtToken authenticate(@RequestBody Credentials credentials) {
		LOGGER.info("Authenticating user {}", credentials);

		return authDelegate.authenticate(credentials);
	}
}
