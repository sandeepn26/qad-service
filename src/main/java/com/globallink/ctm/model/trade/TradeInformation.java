package com.globallink.ctm.model.trade;

public class TradeInformation {

	private String tradeDate;
	private String originatorReference;
	private String commonReference;
	private String relatedReference;
	private String settlementSessionIdentifier;
	private String splitTradeIndicator;

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getOriginatorReference() {
		return originatorReference;
	}

	public void setOriginatorReference(String originatorReference) {
		this.originatorReference = originatorReference;
	}

	public String getCommonReference() {
		return commonReference;
	}

	public void setCommonReference(String commonReference) {
		this.commonReference = commonReference;
	}

	public String getRelatedReference() {
		return relatedReference;
	}

	public void setRelatedReference(String relatedReference) {
		this.relatedReference = relatedReference;
	}

	public String getSettlementSessionIdentifier() {
		return settlementSessionIdentifier;
	}

	public void setSettlementSessionIdentifier(String settlementSessionIdentifier) {
		this.settlementSessionIdentifier = settlementSessionIdentifier;
	}

	public String getSplitTradeIndicator() {
		return splitTradeIndicator;
	}

	public void setSplitTradeIndicator(String splitTradeIndicator) {
		this.splitTradeIndicator = splitTradeIndicator;
	}
}
