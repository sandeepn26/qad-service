package com.globallink.ctm.model.trade;

public class TradeAmounts {

	private Long buyAmount;
	private String buyCurrency;
	private Long sellAmount;
	private String sellCurrency;
	private String settlementDate;

	public Long getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(Long buyAmount) {
		this.buyAmount = buyAmount;
	}

	public String getBuyCurrency() {
		return buyCurrency;
	}

	public void setBuyCurrency(String buyCurrency) {
		this.buyCurrency = buyCurrency;
	}

	public Long getSellAmount() {
		return sellAmount;
	}

	public void setSellAmount(Long sellAmount) {
		this.sellAmount = sellAmount;
	}

	public String getSellCurrency() {
		return sellCurrency;
	}

	public void setSellCurrency(String sellCurrency) {
		this.sellCurrency = sellCurrency;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

}
