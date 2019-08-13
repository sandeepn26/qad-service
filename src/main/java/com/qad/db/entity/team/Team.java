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
@Table(name = "member")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEAM_ID", updatable = false)
	private Long teamId;
	
	@Column(name = "TEAM_TYPE")
	private String teamType;
	
	@Column(name = "TEAM_CODE")
	private String teamCode;
	
	@Column(name = "TEAM_NAME")
	private String teamName;
	
	@Column(name = "TEAM_DESCRIPTION")
	private String teamDescription;
	
	@Column(name = "TEAM_AGE_MIN")
	private Integer teamAgeMin;
	
	@Column(name = "TEAM_AGE_MAX")
	private Integer teamAgeMax;
	
	@Column(name = "ACTIVE")
	private boolean active;
	
	@Column(name = "OWNER_ID")
	private Long ownerId;
	
	@Embedded
	private AuditInfo auditInfo;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamType() {
		return teamType;
	}

	public void setTeamType(String teamType) {
		this.teamType = teamType;
	}

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamDescription() {
		return teamDescription;
	}

	public void setTeamDescription(String teamDescription) {
		this.teamDescription = teamDescription;
	}

	public Integer getTeamAgeMin() {
		return teamAgeMin;
	}

	public void setTeamAgeMin(Integer teamAgeMin) {
		this.teamAgeMin = teamAgeMin;
	}

	public Integer getTeamAgeMax() {
		return teamAgeMax;
	}

	public void setTeamAgeMax(Integer teamAgeMax) {
		this.teamAgeMax = teamAgeMax;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}
}
