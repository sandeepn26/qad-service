package com.qad.delegate;

import java.util.List;
import java.util.Optional;

import com.qad.auth.config.AppUserDetails;
import com.qad.model.Credentials;
import com.qad.model.User;
import com.qad.model.UserProfile;

public interface IUserDelegate {

	public void createDefaultRoles();
	
	public void createDefaultUser();
	
	public void createUser(String email, String password, String displayName);
	
	public void createUser(String email, String password, Optional<String> displayName);
	
	public List<User> getUsers();
	
	public UserProfile getUserProfile(String email);
	
	public void createUser(User user);

	public void createOrUpdateUserProfile(UserProfile userProfile);

	public boolean authenticate(Credentials credentials);
	
	public AppUserDetails findByEmail(String email);
}
