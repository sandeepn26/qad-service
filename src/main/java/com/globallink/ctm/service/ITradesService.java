package com.globallink.ctm.service;

import java.util.Optional;

import com.globallink.ctm.model.trade.Trades;

public interface ITradesService {

	public Trades getAllTrades(String since, String side, Optional<String> clientId, Optional<String> session);
}
