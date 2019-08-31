package com.qad.delegate.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.qad.exceptions.QADServiceException;
import com.qad.model.Credentials;
import com.qad.model.JwtToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class AuthDelegate implements IAuthDelegate {
	private static final Logger LOGGER = LogManager.getLogger(AuthDelegate.class);

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
			throw new QADServiceException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new QADServiceException("INVALID_CREDENTIALS", e);
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

	public Optional<String> getUsernameFromToken(String token) {
		return Optional.ofNullable(getClaimFromToken(token, Claims::getSubject));
	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		Optional<Claims> claims = getAllClaimsFromToken(token);
		if(claims.isPresent()) {
			return claimsResolver.apply(claims.get());
		}
		return null;
	}

	// for retrieveing any information from token we will need the secret key
	private Optional<Claims> getAllClaimsFromToken(String token) {
		try {
			Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			return Optional.ofNullable(claims);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
				| IllegalArgumentException e) {
			LOGGER.error("Error finding claims for token {}", token);
		}

		return Optional.empty();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token).get();
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
}
