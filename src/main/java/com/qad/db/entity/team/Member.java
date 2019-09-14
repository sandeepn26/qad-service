package com.qad.db.entity.team;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.qad.db.entity.AuditInfo;

@Entity
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MEMBER_ID", updatable = false)
	private Long memberId;
	
	@Column(name = "MEMBER_USER_ID")
	private Long memberUserId;
	
	@Column(name = "MEMBER_CODE")
	private String memberCode;
	
	@Column(name = "PARENT_GUARDIAN_ID")
	private Long parentGuardianId;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "DISPLAY_NAME")
	private String displayName;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DATE_OF_BIRTH")
	private LocalDate dob;
	
	@Column(name = "QUESTION_DAY")
	private String questionDay;
	
	@Embedded
	private AuditInfo auditInfo = new AuditInfo();

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getMemberUserId() {
		return memberUserId;
	}

	public void setMemberUserId(Long memberUserId) {
		this.memberUserId = memberUserId;
	}

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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getQuestionDay() {
		return questionDay;
	}

	public void setQuestionDay(String questionDay) {
		this.questionDay = questionDay;
	}

	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}
}
