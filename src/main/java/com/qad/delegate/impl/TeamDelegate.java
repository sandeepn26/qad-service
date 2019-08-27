package com.qad.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.db.service.ITeamDBService;
import com.qad.delegate.ITeamDelegate;
import com.qad.model.QADResponse;
import com.qad.model.team.TeamVo;

@Service
public class TeamDelegate implements ITeamDelegate {

	@Autowired
	ITeamDBService teamDBService;

	@Override
	public QADResponse createTeam(TeamVo team) {
		teamDBService.createTeam(team);
		return QADResponse.TEAM_CREATED;
	}
}
