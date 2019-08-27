package com.qad.db.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.auth.config.AuthUtils;
import com.qad.db.entity.team.Team;
import com.qad.db.repository.TeamRepository;
import com.qad.db.service.ITeamDBService;
import com.qad.model.team.TeamVo;
import com.qad.util.RandomUtils;

@Service
public class TeamDBService implements ITeamDBService {

	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Long createTeam(TeamVo teamVo) {
		Team team = new Team();
		BeanUtils.copyProperties(teamVo, team);
		
		team.setTeamCode(RandomUtils.generateTeamCode());
		team.setOwnerId(AuthUtils.getCurrentUserId());
		team.setActive(true);
		
		team = teamRepository.save(team);

		return team.getTeamId();
	}

}
