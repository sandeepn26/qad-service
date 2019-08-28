package com.qad.db.entity.team;

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
@Table(name = "TEAM_MEMBER_MAP")
@EntityListeners(AuditingEntityListener.class)
public class TeamMemberMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MAPPING_ID", updatable = false)
	private Long mappingId;

	@Column(name = "MEMBER_CODE")
	private String memberCode;

	@Column(name = "TEAM_CODE")
	private String teamCode;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "MODIFY_REASON")
	private String modifyReason;

	@Embedded
	private AuditInfo auditInfo = new AuditInfo();

	public Long getMappingId() {
		return mappingId;
	}

	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}

	public String getModifyReason() {
		return modifyReason;
	}

	public void setModifyReason(String modifyReason) {
		this.modifyReason = modifyReason;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
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
