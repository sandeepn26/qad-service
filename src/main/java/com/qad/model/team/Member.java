package com.qad.model.team;

import java.util.Date;

public class Member {

	private String memberCode;

	private Long parentGuardianId;

	private String lastName;

	private String firstName;

	private String displayName;

	private boolean active;

	private String status;

	private Date dob;

	private String questionDay;

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public Long getParentGuardianId() {
		return parentGuardianId;
	}

	public void setParentGuardianId(Long parentGuardianId) {
		this.parentGuardianId = parentGuardianId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getQuestionDay() {
		return questionDay;
	}

	public void setQuestionDay(String questionDay) {
		this.questionDay = questionDay;
	}
}
