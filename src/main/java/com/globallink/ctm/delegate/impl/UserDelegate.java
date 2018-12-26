package com.globallink.ctm.delegate.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallink.ctm.db.service.IRoleDBService;
import com.globallink.ctm.db.service.IUserDBService;
import com.globallink.ctm.delegate.IUserDelegate;
import com.globallink.ctm.model.User;
import com.globallink.ctm.model.UserProfile;

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
}
