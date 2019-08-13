package com.qad.service;

import java.util.Optional;

import com.qad.model.trade.Trades;

public interface ITradesService {

	public Trades getAllTrades(String since, String side, Optional<String> clientId, Optional<String> session);
}
