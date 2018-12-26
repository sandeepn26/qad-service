package com.globallink.ctm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallink.ctm.model.Clients;
import com.globallink.ctm.rest.CTMService;
import com.globallink.ctm.service.IClientService;

@Service
public class ClientService implements IClientService {

	@Autowired
	private CTMService ctmService;

	@Override
	public Clients getAllClients() {
		return ctmService.getAllClients();
	}

}
