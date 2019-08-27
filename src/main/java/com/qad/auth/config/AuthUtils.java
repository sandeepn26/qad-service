package com.qad.auth.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.qad.model.PrincipalUser;

public class AuthUtils {

	public static Long getCurrentUserId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.getPrincipal() == null) return -1L;
		
		PrincipalUser principalUser = (PrincipalUser) authentication.getPrincipal();
		return principalUser.getUserId();
	}
}
