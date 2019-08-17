package com.qad.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.qad.delegate.IUserDelegate;

public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDelegate userDelegate;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDelegate.findByEmail(username);
	}
}
