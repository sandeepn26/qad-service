package com.globallink.ctm.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.globallink.ctm.model.Clients;
import com.globallink.ctm.model.Token;
import com.globallink.ctm.model.trade.Trades;

@Scope("singleton")
@Service
public class CTMService implements CTMConstants {

	private static final Logger LOGGER = LoggerFactory.getLogger(CTMService.class);

	@Autowired
	private CTMRestClient ctmClient;

	public Trades getAllTrades(String since, String side, Optional<String> clientId, Optional<String> session) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put(SINCE, since);
		// parameters.add(SIDE, side);
		if (clientId.isPresent()) {
			parameters.put(CLIENT_ID, clientId.get());
		}
		if (session.isPresent()) {
			parameters.put(SESSION, session.get());
		}

		Trades trades = ctmClient.getAllTrades(parameters);
		LOGGER.info(String.format("Received CLS Response with %d trades", trades.getTrades().size()));
		
		return ctmClient.getAllTrades(parameters);
	}

	public Clients getAllClients() {
		Clients clients = ctmClient.getAllClients();
		LOGGER.info(String.format("Received CLS Response with %d clients", clients.getClients().size()));

		return clients;
	}

	public Token getToken() {
		Token token = ctmClient.getToken();
		LOGGER.info("Token expiry seconds " + token.getExpiresIn());
		return token;
	}
}
