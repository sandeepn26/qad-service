package com.qad.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qad.delegate.ITeamDelegate;
import com.qad.model.QADResponse;
import com.qad.model.team.TeamVo;

@CrossOrigin(origins = { "*" }, methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.OPTIONS }, allowedHeaders = { "*" }, allowCredentials = "true")
@RestController
public class TeamController {
	private static final Logger LOGGER = LogManager.getLogger(TeamController.class);
	
	@Autowired
	private ITeamDelegate teamDelegate;

	@PostMapping(value = "/createTeam", consumes = MediaType.APPLICATION_JSON_VALUE)
	public QADResponse createTeam(@RequestBody TeamVo team) {
		LOGGER.info("Creating team {}", team);
		return teamDelegate.createTeam(team);
	}
}
