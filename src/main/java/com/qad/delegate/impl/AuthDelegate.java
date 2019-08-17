package com.qad.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.db.service.IAuthDBService;
import com.qad.delegate.IAuthDelegate;
import com.qad.model.JwtToken;

@Service
public class AuthDelegate implements IAuthDelegate {

	@Autowired
	private IAuthDBService authDBService;
	
	@Override
	public JwtToken getToken(String token) {
		return authDBService.getToken(token);
	}

	@Override
	public JwtToken getTokenByusername(String username) {
		return authDBService.getTokenByusername(username);
	}
}
