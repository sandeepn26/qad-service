package com.qad.delegate;

import com.qad.model.QADResponse;
import com.qad.model.team.TeamVo;

public interface ITeamDelegate {
	
	public QADResponse createTeam(TeamVo team);
}
