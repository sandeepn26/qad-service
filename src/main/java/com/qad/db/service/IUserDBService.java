package com.qad.db.service;

import java.util.List;

import com.qad.auth.config.AppUserDetails;
import com.qad.model.Credentials;
import com.qad.model.PrincipalUser;
import com.qad.model.UserProfile;
import com.qad.model.team.MemberVo;

public interface IUserDBService {
	
	public void createDefaultUser();
	
	public boolean createUser(String email, String password, String displayName);
	
	public List<com.qad.model.User> getUsers();
	
	public UserProfile getUserProfile(String email);

	public void createOrUpdateUserProfile(UserProfile userProfile);

	public boolean authenticate(Credentials credentials);

	public AppUserDetails getUserByEmail(String email);

	PrincipalUser getPrincipal(String username, String token);

	public void createMember(MemberVo member);
	
	public void createMemberForUser(String email);
}
