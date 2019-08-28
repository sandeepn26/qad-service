package com.qad.delegate;

import com.qad.model.QADResponse;
import com.qad.model.team.TeamVo;

public interface ITeamDelegate {
	
	public QADResponse createTeam(TeamVo team);
	
	public QADResponse updateTeam(TeamVo team);
	
	public QADResponse addMember(String memberCode, String teamCode);
	
	public QADResponse editMember(String memberCode, String teamCode);

	QADResponse removeMember(String memberCode, String teamCode);
}
