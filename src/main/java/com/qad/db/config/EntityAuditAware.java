package com.qad.db.config;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component(value = "entityAuditAware")
public class EntityAuditAware implements AuditorAware<Long> {
	private static final Logger LOGGER = LoggerFactory.getLogger(EntityAuditAware.class);
	
	@Override
	public Optional<Long> getCurrentAuditor() {
		LOGGER.info("");
		return Optional.of(3L);
	}
}
