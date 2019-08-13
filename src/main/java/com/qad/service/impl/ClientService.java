package com.qad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.model.Clients;
import com.qad.rest.CTMService;
import com.qad.service.IClientService;

@Service
public class ClientService implements IClientService {

	@Autowired
	private CTMService ctmService;

	@Override
	public Clients getAllClients() {
		return ctmService.getAllClients();
	}

}
