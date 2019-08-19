package com.qad.auth.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthService {

	public static Object getCurrentUser() {
		Authentication auth = SecurityContextHolder
				.getContext().getAuthentication();
		
		return auth.getPrincipal();
	}
}
