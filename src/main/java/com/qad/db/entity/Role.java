package com.qad.db.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {
	
	@Id
	@Column(name = "ROLE", nullable = false)
	private String role;

	@Column(name = "ROLE_DESCRIPTION", nullable = false)
	private String roleDescription;
	
	@Column(name = "ROLE_LONG_DESCRIPTION", nullable = false)
	private String roleLongDescription;
	
	@Embedded
	private AuditTimes auditTimes;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleLongDescription() {
		return roleLongDescription;
	}

	public void setRoleLongDescription(String roleLongDescription) {
		this.roleLongDescription = roleLongDescription;
	}

	public AuditTimes getAuditTimes() {
		return auditTimes;
	}

	public void setAuditTimes(AuditTimes auditTimes) {
		this.auditTimes = auditTimes;
	}
}
