package com.lps.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lps.errorhandlers.CTMException;
import com.lps.model.CLSResponse;

@Component
public class CTMHealthIndicator implements HealthIndicator {
	
	public static final Health.Builder STATUS_UPDATE_ERROR = new Health.Builder().status("Status Update Error");
	public static final Health.Builder CLS_REQUEST_ERROR = new Health.Builder().status("CLS Request Error");
	public static final Health.Builder FUND_UPDATE_ERROR = new Health.Builder().status("Status Update Error");

	private Health currentHealth = Health.up().build();

	@Override
	public Health health() {
		return currentHealth;
	}

	public void setHealthy() {
		currentHealth = Health.up().build();
	}
	
	public void failStatusUpdateHealth(Object details) {
		currentHealth = STATUS_UPDATE_ERROR.withDetail("details", details).build();
	}
	
	public void failRequestResponseHealth(Object details) {
		currentHealth = CLS_REQUEST_ERROR.withDetail("details", details).build();
	}
	
	public void failHealth(CTMException ctmException) {
		currentHealth = CLS_REQUEST_ERROR.withDetail("details", ctmException).build();
	}

}
