package com.qad.delegate;

import java.util.Optional;

import com.qad.model.Credentials;
import com.qad.model.JwtToken;

public interface IAuthDelegate {

	public JwtToken getToken(String token);

	public JwtToken getTokenByusername(String username);

	JwtToken authenticate(Credentials credentials);

	public Optional<String> getUsernameFromToken(String token);
}
