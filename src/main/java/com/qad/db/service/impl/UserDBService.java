package com.qad.db.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.db.dao.RoleDAO;
import com.qad.db.dao.UserDAO;
import com.qad.db.entity.AuditTimes;
import com.qad.db.entity.Role;
import com.qad.db.entity.User;
import com.qad.db.entity.UserDetail;
import com.qad.db.service.IUserDBService;
import com.qad.model.UserProfile;

@Service
public class UserDBService implements IUserDBService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDBService.class);

	private static final String DEFAULT_USER_EMAIL = "abc@abc.com";

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	UserDAO userDAO;

	private Optional<Role> getDefaultRole() {
		return roleDAO.findById("admin");
	}

	@Override
	public void createDefaultUser() {
		if (getDefaultUser().isPresent()) {
			LOGGER.info("Default user exists");
			return;
		}

		LOGGER.info("Creating default user");
		User user = new User();
		getDefaultRole().ifPresent(user::setRole);
		user.setAuditTimes(new AuditTimes());
		user.setDisplayName("Sandeep N");
		user.setEmail(DEFAULT_USER_EMAIL);
		user.setEnabled(true);
		user.setFailedlogins(0);
		user.setLastLoginDate(new Date());
		user.setLocked(false);
		user.setPassword("test");
		UserDetail userDetails = createDefaultUserDetails();
		user.setUserDetail(userDetails);
		userDetails.setUser(user);
		userDAO.save(user);
	}

	private Optional<User> getDefaultUser() {
		return Optional.ofNullable(userDAO.getByEmail(DEFAULT_USER_EMAIL));
	}

	@Override
	public boolean createUser(String email, String password, String displayName) {
		User user = new User();
		getDefaultRole().ifPresent(user::setRole);
		user.setAuditTimes(new AuditTimes());
		user.setDisplayName(displayName);
		user.setEmail(email);
		user.setEnabled(true);
		user.setFailedlogins(0);
		user.setLastLoginDate(new Date());
		user.setLocked(false);
		user.setPassword(password);
		userDAO.save(user);
		return false;
	}

	@Override
	public List<com.qad.model.User> getUsers() {
		List<User> users = userDAO.findAll();
		List<com.qad.model.User> clientUsers = users.stream().map(user -> createClientUser(user)).collect(Collectors.toList());
		return clientUsers;
	}
	
	private com.qad.model.User createClientUser(User user) {
		com.qad.model.User clientUser = new com.qad.model.User();
		BeanUtils.copyProperties(user, clientUser);
		return clientUser;
	}
	
	private UserDetail createDefaultUserDetails() {
		UserDetail detail = new UserDetail();
		detail.setAddress("80 Barrington");
		detail.setAuditTimes(new AuditTimes());
		detail.setCity("Nashua");
		detail.setCounty("USA");
		detail.setCounty("hb");
		detail.setDateOfBirth(new Date());
		detail.setFirstName("Sandeep");
		detail.setLastName("Nad");
		detail.setState("NH");
		detail.setSecondaryEmail("test@test.com");
		detail.setSecondaryPhone("603-204-1491");
		detail.setPhone("603-204-1491");
		detail.setPostCode("03062");
		
		return detail;
	}
	
	private User getUserByEmail(String email) {
		return userDAO.getByEmail(email);
	}

	@Override
	public UserProfile getUserProfile(String email) {
		User user = getUserByEmail(email);
		UserProfile profile = new UserProfile();
		BeanUtils.copyProperties(user, profile);
		BeanUtils.copyProperties(user.getUserDetail(), profile);
		return profile;
	}

}
