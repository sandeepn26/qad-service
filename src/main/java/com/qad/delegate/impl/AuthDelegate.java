package com.qad.delegate.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.qad.auth.config.AppUserDetailsService;
import com.qad.db.service.IAuthDBService;
import com.qad.delegate.IAuthDelegate;
import com.qad.model.Credentials;
import com.qad.model.JwtToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthDelegate implements IAuthDelegate {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthDelegate.class);

	private static long JWT_TOKEN_VALIDITY = 1000 * 60 * 60;

	private String secret = "testseckey";

	@Autowired
	private IAuthDBService authDBService;

	@Autowired
	private AppUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public JwtToken getToken(String token) {
		return authDBService.getToken(token);
	}

	@Override
	public JwtToken getTokenByusername(String username) {
		return authDBService.getTokenByusername(username);
	}

	@Override
	public JwtToken authenticate(Credentials credentials) {
		String username = credentials.getEmail();
		try {
			LOGGER.info("Authenticating for credentials {}", credentials);
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword()));
		} catch (DisabledException e) {
			throw new RuntimeException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new RuntimeException("INVALID_CREDENTIALS", e);
		}

		final String token = generateToken(userDetailsService.loadUserByUsername(username));
		JwtToken jwtToken = new JwtToken();
		jwtToken.setToken(token);

		return jwtToken;
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
