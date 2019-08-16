package com.qad.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qad.delegate.IUserDelegate;
import com.qad.model.User;
import com.qad.model.UserProfile;

@CrossOrigin(origins = { "*" }, methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.OPTIONS }, allowedHeaders = { "*" }, allowCredentials = "true")
@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserDelegate userDelegate;

	@RequestMapping(value = "/createUser", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS})
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public boolean createUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("displayName") String displayName) {
		userDelegate.createUser(email, password, displayName);
		return true;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
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

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET,
			RequestMethod.OPTIONS }, allowedHeaders = "*", allowCredentials = "true")
	public boolean register(@RequestBody User user) {
		LOGGER.info("Registering user {}", user.getEmail());
		userDelegate.createUser(user);
		return true;
	}
	
	@RequestMapping(value = "/addUpdateProfile", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET,
			RequestMethod.OPTIONS }, allowedHeaders = "*", allowCredentials = "true")
	public boolean postUserDetails(@RequestBody UserProfile userProfile) {
		LOGGER.info("Updating user profile {}", userProfile);
		userDelegate.createOrUpdateUserProfile(userProfile);
		return true;
	}

}
