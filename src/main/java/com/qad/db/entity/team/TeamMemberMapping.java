package com.qad.db.entity.team;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.qad.db.entity.AuditInfo;

@Entity
@Table(name = "TEAM_MEMBER_MAP")
public class TeamMemberMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAPPING_ID", updatable = false)
	private Long mappingId;
	
	@Column(name = "MEMBER_ID")
	private Long memberId;
	
	@Column(name = "TEAM_ID")
	private Long teamId;
	
	@Column(name = "ACTIVE")
	private boolean active;
	
	@Embedded
	private AuditInfo auditInfo;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}
}
