package com.qad.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qad.delegate.IUserDelegate;
import com.qad.model.QADResponse;
import com.qad.model.User;
import com.qad.model.UserProfile;
import com.qad.model.team.MemberVo;

@CrossOrigin(origins = { "*" }, methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.OPTIONS }, allowedHeaders = { "*" }, allowCredentials = "true")
@RestController
public class UserController {
	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	private IUserDelegate userDelegate;

	@PostMapping(value = "/createUser")
	public boolean createUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("displayName") String displayName) {
		userDelegate.createUser(email, password, displayName);
		return true;
	}

	@GetMapping(value = "/users")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<User> getUsers() {
		return userDelegate.getUsers();
	}

	@RequestMapping(value = "/profile/{email}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public UserProfile getUserProfile(@PathVariable("email") String email) {
		LOGGER.info("requested profile for email {}", email);
		return userDelegate.getUserProfile(email);
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean register(@RequestBody User user) {
		LOGGER.info("Registering user {}", user.getEmail());
		userDelegate.createUser(user);
		return true;
	}

	@PostMapping(value = "/addUpdateProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean postUserDetails(@RequestBody UserProfile userProfile) {
		LOGGER.info("Updating user profile {}", userProfile);
		userDelegate.createOrUpdateUserProfile(userProfile);
		return true;
	}

	@PostMapping(value = "/login")
	public QADResponse login(@RequestParam("username") String username, @RequestParam("password") String password) {
		return QADResponse.LOGIN_SUCCESS;
	}
	
	@PostMapping(value = "/createMember", consumes = MediaType.APPLICATION_JSON_VALUE)
	public QADResponse createMember(@RequestBody MemberVo member) {
		LOGGER.info("Creating member {} {}", member.getFirstName(), member.getLastName());
		return userDelegate.createMember(member);
	}
	
	@PostMapping(value = "/updateMember", consumes = MediaType.APPLICATION_JSON_VALUE)
	public QADResponse updateMember(@RequestBody MemberVo member) {
		LOGGER.info("Updating member {} {}", member.getFirstName(), member.getLastName());
		return userDelegate.updateMember(member);
	}
	
	@PostMapping(value = "/deactivateMember")
	public QADResponse deactivateMember(String memberCode) {
		LOGGER.info("Deactivating member {}", memberCode);
		return userDelegate.deactivateMember(memberCode);
	}

	@PostMapping(value = "/initMembership")
	public QADResponse createMemberForUser(@RequestParam("email") String email) {
		LOGGER.info("Creating member for user {}", email);
		return userDelegate.createMemberForUser(email);
	}

}
