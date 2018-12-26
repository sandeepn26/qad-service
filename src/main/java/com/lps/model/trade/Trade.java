package com.lps.model.trade;

public class Trade {
	
	private String clientId;
	
	private Long version;
	
	private String timestamp;
	
	private String recordType;
	
	private StatusDetails statusDetails;
	
	private TradeInformation tradeInformation;
	
	private TradingSide tradingSide;
	
	private CounterPartySide counterPartySide;
	
	private TradeAmounts tradeAmounts;
	
	private AgreedRate agreedRate;
	
	private GeneralInformation generalInformation;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public StatusDetails getStatusDetails() {
		return statusDetails;
	}

	public void setStatusDetails(StatusDetails statusDetails) {
		this.statusDetails = statusDetails;
	}

	public TradeInformation getTradeInformation() {
		return tradeInformation;
	}

	public void setTradeInformation(TradeInformation tradeInformation) {
		this.tradeInformation = tradeInformation;
	}

	public TradingSide getTradingSide() {
		return tradingSide;
	}

	public void setTradingSide(TradingSide tradingSide) {
		this.tradingSide = tradingSide;
	}

	public CounterPartySide getCounterPartySide() {
		return counterPartySide;
	}

	public void setCounterPartySide(CounterPartySide counterPartySide) {
		this.counterPartySide = counterPartySide;
	}

	public TradeAmounts getTradeAmounts() {
		return tradeAmounts;
	}

	public void setTradeAmounts(TradeAmounts tradeAmounts) {
		this.tradeAmounts = tradeAmounts;
	}

	public AgreedRate getAgreedRate() {
		return agreedRate;
	}

	public void setAgreedRate(AgreedRate agreedRate) {
		this.agreedRate = agreedRate;
	}

	public GeneralInformation getGeneralInformation() {
		return generalInformation;
	}

	public void setGeneralInformation(GeneralInformation generalInformation) {
		this.generalInformation = generalInformation;
	}
}
