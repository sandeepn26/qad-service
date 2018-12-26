package com.lps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lps.model.Clients;
import com.lps.rest.CTMService;
import com.lps.service.IClientService;

@Service
public class ClientService implements IClientService {

	@Autowired
	private CTMService ctmService;

	@Override
	public Clients getAllClients() {
		return ctmService.getAllClients();
	}

}
