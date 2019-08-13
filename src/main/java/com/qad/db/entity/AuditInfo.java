package com.qad.db.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class AuditInfo {

	@Column(name = "CREATE_USER", nullable = false)
	private Long createUser;

	@Embedded
	private AuditTimes auditTimes;

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public AuditTimes getAuditTimes() {
		return auditTimes;
	}

	public void setAuditTimes(AuditTimes auditTimes) {
		this.auditTimes = auditTimes;
	}
}
