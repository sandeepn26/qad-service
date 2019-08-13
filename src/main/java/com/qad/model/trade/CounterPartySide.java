package com.qad.model.trade;

public class CounterPartySide {

	private String submittingPartyBIC;
	private String tradePartyName;
	private String tradePartyBIC;

	public String getSubmittingPartyBIC() {
		return submittingPartyBIC;
	}

	public void setSubmittingPartyBIC(String submittingPartyBIC) {
		this.submittingPartyBIC = submittingPartyBIC;
	}

	public String getTradePartyName() {
		return tradePartyName;
	}

	public void setTradePartyName(String tradePartyName) {
		this.tradePartyName = tradePartyName;
	}

	public String getTradePartyBIC() {
		return tradePartyBIC;
	}

	public void setTradePartyBIC(String tradePartyBIC) {
		this.tradePartyBIC = tradePartyBIC;
	}
}
