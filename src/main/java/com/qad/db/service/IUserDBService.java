package com.qad.db.service;

import java.util.List;

import com.qad.model.UserProfile;

public interface IUserDBService {
	
	public void createDefaultUser();
	
	public boolean createUser(String email, String password, String displayName);
	
	public List<com.qad.model.User> getUsers();
	
	public UserProfile getUserProfile(String email);

	public void createOrUpdateUserProfile(UserProfile userProfile);
}
