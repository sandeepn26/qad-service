package com.globallink.ctm.db.service;

import java.util.List;

import com.globallink.ctm.model.UserProfile;

public interface IUserDBService {
	
	public void createDefaultUser();
	
	public boolean createUser(String email, String password, String displayName);
	
	public List<com.globallink.ctm.model.User> getUsers();
	
	public UserProfile getUserProfile(String email);
}
