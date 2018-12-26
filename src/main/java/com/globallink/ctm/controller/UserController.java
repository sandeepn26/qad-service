package com.globallink.ctm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallink.ctm.delegate.IUserDelegate;
import com.globallink.ctm.model.User;
import com.globallink.ctm.model.UserProfile;

@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.OPTIONS }, allowedHeaders = { "http://localhost:4200" }, allowCredentials = "true")
@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserDelegate userDelegate;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
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
	@CrossOrigin(origins = "http://localhost:4200")
	public UserProfile getUserProfile(@PathVariable("email") String email) {
		LOGGER.info("requested profile for email {}", email);
		return userDelegate.getUserProfile(email);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:4200" }, methods = { RequestMethod.POST, RequestMethod.GET,
			RequestMethod.OPTIONS }, allowedHeaders = { "http://localhost:4200" }, allowCredentials = "true")
	public boolean register(@RequestBody User user) {
		LOGGER.info("Registering user {}", user.getEmail());
		userDelegate.createUser(user);
		return true;
	}

}
