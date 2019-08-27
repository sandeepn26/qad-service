package com.qad.model.team;

public class TeamVo {

	private String teamType;

	private String teamCode;

	private String teamName;

	private String teamDescription;

	private Integer teamAgeMin;

	private Integer teamAgeMax;

	private boolean active;

	private Long ownerId;

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
}
