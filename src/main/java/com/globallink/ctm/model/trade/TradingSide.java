package com.globallink.ctm.model.trade;

public class TradingSide {

	private String submittingPartyBIC;
	private String tradePartyName;
	private String tradePartyBIC;
	private FundIdentification fundIdentification;

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

	public FundIdentification getFundIdentification() {
		return fundIdentification;
	}

	public void setFundIdentification(FundIdentification fundIdentification) {
		this.fundIdentification = fundIdentification;
	}

}
