package com.qad.db.entity.team;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.qad.db.entity.AuditInfo;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID", updatable = false)
	private Long memberId;
	
	@Column(name = "PARENT_GUARDIAN_ID")
	private Long parentGuardianId;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "FIRST_NAME")
	private String displayName;

	@Column(name = "DISPLAY_NAME")
	private String password;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DATE_OF_BIRTH")
	private Date dob;
	
	@Column(name = "QUESTION_DAY")
	private Integer questionDay;
	
	@Embedded
	private AuditInfo auditInfo;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getQuestionDay() {
		return questionDay;
	}

	public void setQuestionDay(Integer questionDay) {
		this.questionDay = questionDay;
	}

	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}
}
