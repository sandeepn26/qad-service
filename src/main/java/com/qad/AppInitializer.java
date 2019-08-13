package com.qad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.qad.delegate.IUserDelegate;

@Component
public class AppInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppInitializer.class);

	@Autowired
	private IUserDelegate userDelegate;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		LOGGER.info("In AppInitializer ********************");
		userDelegate.createDefaultRoles();
		userDelegate.createDefaultUser();
	}
}
