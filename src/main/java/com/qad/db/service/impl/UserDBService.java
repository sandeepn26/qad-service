package com.qad.db.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qad.auth.config.AppUserDetails;
import com.qad.controller.UserController;
import com.qad.db.entity.AuditInfo;
import com.qad.db.entity.AuditTimes;
import com.qad.db.entity.Role;
import com.qad.db.entity.User;
import com.qad.db.entity.UserDetail;
import com.qad.db.repository.RoleRepository;
import com.qad.db.repository.UserProfileRepository;
import com.qad.db.repository.UserRepository;
import com.qad.db.service.IUserDBService;
import com.qad.model.Credentials;
import com.qad.model.PrincipalUser;
import com.qad.model.UserProfile;

@Service
public class UserDBService implements IUserDBService {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	
	private static final String DEFAULT_USER_EMAIL = "abc@abc.com";

	@Autowired
	RoleRepository roleDAO;

	@Autowired
	UserRepository userDAO;

	@Autowired
	UserProfileRepository userProfileRepository;

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
		user.setEmailVerificationToken(UUID.randomUUID().toString());
		user.setLastLoginDate(new Date());
		user.setLocked(false);
		user.setPassword("test");
		user = userDAO.save(user);

		UserDetail userDetails = createDefaultUserDetails();
		AuditInfo ai = userDetails.getAuditInfo();
		ai.setCreatedBy(user.getUserId());
		user.setUserDetail(userDetails);
		userDetails.setUser(user);

		userDAO.save(user);
	}

	private Optional<User> getDefaultUser() {
		return userDAO.findByEmail(DEFAULT_USER_EMAIL);
	}

	@Override
	public boolean createUser(String email, String password, String displayName) {
		User user = new User();
		getDefaultRole().ifPresent(user::setRole);
		// user.setAuditTimes(new AuditTimes());
		user.setDisplayName(displayName);
		user.setEmail(email);
		user.setEnabled(true);
		user.setFailedlogins(0);
		user.setLastLoginDate(new Date());
		user.setLocked(false);
		user.setPassword(password);
		user.setEmailVerificationToken(RandomStringUtils.randomAlphabetic(10));
		userDAO.save(user);
		return false;
	}

	@Override
	public List<com.qad.model.User> getUsers() {
		List<User> users = userDAO.findAll();
		List<com.qad.model.User> clientUsers = users.stream().map(user -> createClientUser(user))
				.collect(Collectors.toList());
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
		detail.setCity("Nashua");
		detail.setCounty("USA");
		detail.setCounty("hb");
		detail.setDateOfBirth(LocalDate.now());
		detail.setFirstName("Sandeep");
		detail.setLastName("Nad");
		detail.setState("NH");
		detail.setSecondaryEmail("test@test.com");
		detail.setSecondaryPhone("603-204-1491");
		detail.setPhone("603-204-1491");
		detail.setPostCode("03062");

		return detail;
	}

	@Override
	public UserProfile getUserProfile(String email) {
		UserProfile profile = new UserProfile();
		userDAO.findByEmail(email).ifPresent(user -> {
			BeanUtils.copyProperties(user, profile);
			BeanUtils.copyProperties(user.getUserDetail(), profile);
		});
		return profile;
	}

	@Override
	public void createOrUpdateUserProfile(UserProfile userProfile) {
		UserDetail userDetail = null;
		if (userProfile.getId() == null) {
			userDetail = new UserDetail();
		} else {
			userDetail = userProfileRepository.findById(userProfile.getId()).get();
		}
		BeanUtils.copyProperties(userProfile, userDetail);
		userDetail.setUser(userDAO.findById(3L).get());
		userProfileRepository.save(userDetail);
	}

	@Override
	public boolean authenticate(Credentials credentials) {
		return userDAO.findByEmail(credentials.getEmail()).isPresent();
	}

	@Override
	public AppUserDetails getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userDAO.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Invalid Credentials"));
		com.qad.model.User userVo = new com.qad.model.User();
		AppUserDetails AppUserDetails = new AppUserDetails(userVo);
		BeanUtils.copyProperties(user, userVo);

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		userVo.setPassword(hashedPassword);

		return AppUserDetails;
	}

	@Override
	public PrincipalUser getPrincipal(String username, String token) {
		PrincipalUser PrincipalUser = new PrincipalUser();
		userDAO.findByEmail(username).ifPresent(user -> {
			BeanUtils.copyProperties(user, PrincipalUser);
		});

		return PrincipalUser;
	}

}
