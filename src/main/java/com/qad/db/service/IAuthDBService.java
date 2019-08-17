package com.qad.db.service;

import com.qad.model.JwtToken;

public interface IAuthDBService {

	public JwtToken getToken(String token);

	public JwtToken getTokenByusername(String username);
}
