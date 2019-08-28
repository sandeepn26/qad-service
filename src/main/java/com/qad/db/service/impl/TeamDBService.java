package com.qad.db.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qad.auth.config.AuthUtils;
import com.qad.db.entity.team.Team;
import com.qad.db.entity.team.TeamMemberMapping;
import com.qad.db.repository.TeamMemberMappingRepository;
import com.qad.db.repository.TeamRepository;
import com.qad.db.service.ITeamDBService;
import com.qad.model.team.TeamVo;
import com.qad.util.Messages;
import com.qad.util.RandomUtils;

@Service
public class TeamDBService implements ITeamDBService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TeamDBService.class);

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TeamMemberMappingRepository mappingRepository;

	@Override
	public Long createTeam(TeamVo teamVo) {
		Team team = new Team();
		BeanUtils.copyProperties(teamVo, team);

		team.setTeamCode(RandomUtils.generateTeamCode());
		team.setOwnerId(AuthUtils.getCurrentUserId());
		team.setActive(true);

		team = this.teamRepository.save(team);

		return team.getTeamId();
	}

	@Override
	public void updateTeam(TeamVo teamVo) {
		String teamCode = teamVo.getTeamCode();
		Team team = this.teamRepository.findByTeamCode(teamCode)
				.orElseThrow(() -> new IllegalArgumentException(Messages.invalidIdentifier("teamCode", teamCode)));
		
		BeanUtils.copyProperties(teamVo, team);
		this.teamRepository.save(team);
	}

	@Override
	public void addMember(String memberCode, String teamCode) {
		Optional<TeamMemberMapping> mappingOpt = mappingRepository.findByMemberCodeAndTeamCode(memberCode, teamCode);
		if(mappingOpt.isPresent()) {
			TeamMemberMapping mapping = mappingOpt.get();
			if(mapping.isActive()) {
				LOGGER.warn("Member {} is already in the team {} so no action will be taken", memberCode, teamCode);
				return;
			}
			
			LOGGER.info("Activating inactive Member {} in the team {}", memberCode, teamCode);
			mapping.setActive(true);
			this.mappingRepository.save(mapping);
			return;
		}
		
		LOGGER.info("Adding member {} to the team {}", memberCode, teamCode);
		TeamMemberMapping mapping = new TeamMemberMapping();
		mapping.setMemberCode(memberCode);
		mapping.setTeamCode(teamCode);
		mapping.setActive(true);
	}

	@Override
	public void removeMember(String memberCode, String teamCode) {
		Optional<TeamMemberMapping> mappingOpt = mappingRepository.findByMemberCodeAndTeamCode(memberCode, teamCode);
		TeamMemberMapping mapping = mappingOpt.orElseThrow(() -> new IllegalArgumentException(Messages.invalidIdentifier("teamCode", teamCode)));
		
		LOGGER.info("De-activating Member {} in the team {}", memberCode, teamCode);
		mapping.setActive(false);
		
		this.mappingRepository.save(mapping);
	}

}
