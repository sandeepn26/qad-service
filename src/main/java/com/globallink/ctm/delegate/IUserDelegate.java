package com.globallink.ctm.delegate;

import java.util.List;
import java.util.Optional;

import com.globallink.ctm.model.User;
import com.globallink.ctm.model.UserProfile;

public interface IUserDelegate {

	public void createDefaultRoles();
	
	public void createDefaultUser();
	
	public void createUser(String email, String password, String displayName);
	
	public void createUser(String email, String password, Optional<String> displayName);
	
	public List<User> getUsers();
	
	public UserProfile getUserProfile(String email);
	
	public void createUser(User user);
}
