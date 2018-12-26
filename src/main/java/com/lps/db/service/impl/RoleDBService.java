package com.lps.db.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lps.db.dao.RoleDAO;
import com.lps.db.dao.UserDAO;
import com.lps.db.entity.AuditTimes;
import com.lps.db.entity.Role;
import com.lps.db.service.IRoleDBService;

@Service
public class RoleDBService implements IRoleDBService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleDBService.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	UserDAO userDAO;

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

		roleDAO.save(role);
		return true;
	}

	private Optional<Role> getDefaultRole() {
		return roleDAO.findById("admin");
	}
}
