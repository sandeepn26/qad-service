package com.lps.db.service;

import java.util.List;

import com.lps.model.UserProfile;

public interface IUserDBService {
	
	public void createDefaultUser();
	
	public boolean createUser(String email, String password, String displayName);
	
	public List<com.lps.model.User> getUsers();
	
	public UserProfile getUserProfile(String email);
}
