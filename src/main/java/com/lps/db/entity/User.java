package com.lps.db.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proman_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", updatable = false, nullable = false)
	private Integer userId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE")
	private Role role;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private UserDetail userDetail;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "DISPLAY_NAME", nullable = false)
	private String displayName;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "FAILED_LOGINS", nullable = false)
	private Integer failedlogins;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Column(name = "locked", nullable = false)
	private boolean locked;

	@Column(name = "last_login_date", nullable = false)
	private Date lastLoginDate;

	@Embedded
	private AuditTimes auditTimes;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getFailedlogins() {
		return failedlogins;
	}

	public void setFailedlogins(Integer failedlogins) {
		this.failedlogins = failedlogins;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public AuditTimes getAuditTimes() {
		return auditTimes;
	}

	public void setAuditTimes(AuditTimes auditTimes) {
		this.auditTimes = auditTimes;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
}
