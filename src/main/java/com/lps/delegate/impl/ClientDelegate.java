package com.lps.delegate.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lps.db.service.IRoleDBService;
import com.lps.delegate.IClientDelegate;

@Service
public class ClientDelegate implements IClientDelegate {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientDelegate.class);

	@Autowired
	private IRoleDBService roleDBService;

	@Override
	public boolean updateCLSClients() {
		roleDBService.createRole();

		return false;
	}
}