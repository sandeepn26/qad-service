package com.qad.db.service.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.controller.UserController;
import com.qad.db.entity.AuditTimes;
import com.qad.db.entity.Role;
import com.qad.db.repository.RoleRepository;
import com.qad.db.repository.UserRepository;
import com.qad.db.service.IRoleDBService;

@Service
public class RoleDBService implements IRoleDBService {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	UserRepository userRepo;

	@Override
	public boolean createRole() {
		return true;
	}

	@Override
	public boolean createDefaultRoles() {
		if (getDefaultRole().isPresent()) {
			LOGGER.info("Default role exists");
			return true;
		}
		LOGGER.info("Initializing default roles");
		Role role = new Role();
		role.setRole("admin");
		role.setRoleDescription("admin desc");
		role.setRoleLongDescription("role long desc");

		AuditTimes auditTimes = new AuditTimes();
		// auditTimes.setAuditTime(date);
		// auditTimes.setCreateTime(date);

		role.setAuditTimes(auditTimes);

		roleRepo.save(role);
		return true;
	}

	private Optional<Role> getDefaultRole() {
		return roleRepo.findById("admin");
	}
}
