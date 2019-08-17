package com.qad.delegate.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.auth.config.AppUserDetails;
import com.qad.db.service.IRoleDBService;
import com.qad.db.service.IUserDBService;
import com.qad.delegate.IUserDelegate;
import com.qad.model.Credentials;
import com.qad.model.User;
import com.qad.model.UserProfile;

@Service
public class UserDelegate implements IUserDelegate {

	@Autowired
	private IRoleDBService roleDBService;
	
	@Autowired
	private IUserDBService userDBService;
	
	@Override
	public void createDefaultRoles() {
		roleDBService.createDefaultRoles();
	}

	@Override
	public void createDefaultUser() {
		userDBService.createDefaultUser();
	}

	@Override
	public void createUser(String email, String password, String displayName) {
		userDBService.createUser(email, password, displayName);
	}

	@Override
	public List<User> getUsers() {
		return userDBService.getUsers();
	}

	@Override
	public UserProfile getUserProfile(String email) {
		return userDBService.getUserProfile(email);
	}

	@Override
	public void createUser(String email, String password, Optional<String> displayName) {
		String displayNameStr = displayName.orElse(email.substring(0, email.indexOf("@")-1));
		userDBService.createUser(email, password, displayNameStr);
		
	}

	@Override
	public void createUser(User user) {
		createUser(user.getEmail(), user.getPassword(), Optional.ofNullable(user.getDisplayName()));
	}

	@Override
	public void createOrUpdateUserProfile(UserProfile userProfile) {
		userDBService.createOrUpdateUserProfile(userProfile);
		
	}

	@Override
	public boolean authenticate(Credentials credentials) {
		boolean isValidUser = userDBService.authenticate(credentials);
		return isValidUser;
	}

	@Override
	public AppUserDetails findByEmail(String email) {
		return userDBService.getUserByEmail(email);
	}
}
