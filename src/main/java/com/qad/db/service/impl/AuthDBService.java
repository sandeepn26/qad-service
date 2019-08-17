package com.qad.db.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.db.repository.TokenRepository;
import com.qad.db.service.IAuthDBService;
import com.qad.model.JwtToken;

@Service
public class AuthDBService implements IAuthDBService {

	@Autowired
	private TokenRepository tokenRepository;
	
	@Override
	public JwtToken getToken(String token) {
		return createTokenVo(tokenRepository.findByToken(token));
	}

	@Override
	public JwtToken getTokenByusername(String username) {
		return createTokenVo(tokenRepository.findByUsername(username));
	}
	
	private static JwtToken createTokenVo(Optional<com.qad.db.entity.auth.JwtToken> jwtTokenOpt) {
		JwtToken jwtTokenVo = new JwtToken();
		jwtTokenOpt.ifPresent(t -> {
			BeanUtils.copyProperties(t, jwtTokenVo);
		});
		
		return jwtTokenVo;
	}
}
