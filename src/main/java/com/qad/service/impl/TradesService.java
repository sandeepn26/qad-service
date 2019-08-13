package com.qad.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.model.trade.Trades;
import com.qad.rest.CTMService;
import com.qad.service.ITradesService;

@Service
public class TradesService implements ITradesService {

	@Autowired
	private CTMService ctmService;

	@Override
	public Trades getAllTrades(String since, String side, Optional<String> clientId, Optional<String> session) {
		return ctmService.getAllTrades(since, side, clientId, session);
	}
}
