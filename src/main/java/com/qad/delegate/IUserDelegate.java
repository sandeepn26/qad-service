package com.qad.delegate;

import java.util.List;
import java.util.Optional;

import com.qad.auth.config.AppUserDetails;
import com.qad.model.Credentials;
import com.qad.model.PrincipalUser;
import com.qad.model.QADResponse;
import com.qad.model.User;
import com.qad.model.UserProfile;
import com.qad.model.team.MemberVo;

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
	
	public PrincipalUser getPrincipalForToken(String username, String token);

	public QADResponse createMember(MemberVo member);
	
	public QADResponse createMemberForUser(String email);
	
	public QADResponse updateMember(MemberVo memberVo);
	
	public QADResponse deactivateMember(String memberCode);
}
