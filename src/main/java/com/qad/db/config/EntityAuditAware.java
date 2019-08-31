package com.qad.db.config;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.qad.auth.config.AuthUtils;

@Component(value = "entityAuditAware")
public class EntityAuditAware implements AuditorAware<Long> {
	private static final Logger LOGGER = LogManager.getLogger(EntityAuditAware.class);
	
	@Override
	public Optional<Long> getCurrentAuditor() {
		LOGGER.info("Fetching current user id");
		return Optional.of(AuthUtils.getCurrentUserId());
	}
}
