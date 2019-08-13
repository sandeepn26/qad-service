package com.qad.model.trade;

public class StatusDetails {

	private String matchingSystemUniqueReference;
	private String matchingSystemMatchingReference;
	private String currentStatus;
	private String currentStatusDateTime;
	private Long allegedTrade;

	public String getMatchingSystemUniqueReference() {
		return matchingSystemUniqueReference;
	}

	public void setMatchingSystemUniqueReference(String matchingSystemUniqueReference) {
		this.matchingSystemUniqueReference = matchingSystemUniqueReference;
	}

	public String getMatchingSystemMatchingReference() {
		return matchingSystemMatchingReference;
	}

	public void setMatchingSystemMatchingReference(String matchingSystemMatchingReference) {
		this.matchingSystemMatchingReference = matchingSystemMatchingReference;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getCurrentStatusDateTime() {
		return currentStatusDateTime;
	}

	public void setCurrentStatusDateTime(String currentStatusDateTime) {
		this.currentStatusDateTime = currentStatusDateTime;
	}

	public Long getAllegedTrade() {
		return allegedTrade;
	}

	public void setAllegedTrade(Long allegedTrade) {
		this.allegedTrade = allegedTrade;
	}
}
