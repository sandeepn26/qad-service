package com.globallink.ctm.model.trade;

public class FundIdentification {

	private String fundId;
	private String fundName;
	private String custodianBIC;

	public String getFundId() {
		return fundId;
	}

	public void setFundId(String fundId) {
		this.fundId = fundId;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getCustodianBIC() {
		return custodianBIC;
	}

	public void setCustodianBIC(String custodianBIC) {
		this.custodianBIC = custodianBIC;
	}

}
