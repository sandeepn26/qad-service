package com.qad.db.service;

import com.qad.model.team.TeamVo;

public interface ITeamDBService {

	public static final String INVALID_IDENTIFIER = "Invalid Identifier for %s : %s";
	
	public Long createTeam(TeamVo teamVo);
	
	public void updateTeam(TeamVo teamVo);
	
	public void addMember(String memberCode, String teamCode);
	
	public void removeMember(String memberCode, String teamCode);
}
