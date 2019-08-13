package com.qad.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Fund {

	private String id;
	private String name;
	private String custodian;
	private String submittingMember;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustodian() {
		return custodian;
	}

	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}

	public String getSubmittingMember() {
		return submittingMember;
	}

	public void setSubmittingMember(String submittingMember) {
		this.submittingMember = submittingMember;
	}

}
