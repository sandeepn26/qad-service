package com.qad.model.trade;

import java.util.List;

public class Trades {

	private Metadata meta;

	private List<Trade> trades;

	public Metadata getMeta() {
		return meta;
	}

	public void setMeta(Metadata meta) {
		this.meta = meta;
	}

	public List<Trade> getTrades() {
		return trades;
	}

	public void setTrades(List<Trade> trades) {
		this.trades = trades;
	}
}
