package com.qad.delegate;

import com.qad.model.Credentials;
import com.qad.model.JwtToken;

public interface IAuthDelegate {

	public JwtToken getToken(String token);

	public JwtToken getTokenByusername(String username);

	JwtToken authenticate(Credentials credentials);
}
