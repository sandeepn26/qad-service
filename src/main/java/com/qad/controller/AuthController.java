package com.qad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qad.delegate.IAuthDelegate;
import com.qad.exceptions.QADServiceException;
import com.qad.model.Credentials;
import com.qad.model.JwtToken;
import com.qad.model.QADResponse;

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

	@ExceptionHandler({ QADServiceException.class })
	public ResponseEntity<QADResponse> handleQADServiceException(QADServiceException e) {
		return ResponseEntity.status(e.getHttpStatus()).body(e.getErrorResponse());
	}
}
