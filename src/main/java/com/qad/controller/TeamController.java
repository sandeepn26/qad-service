package com.qad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

	@Autowired
	private ITeamDelegate teamDelegate;

	@PostMapping(value = "/createTeam", consumes = MediaType.APPLICATION_JSON_VALUE)
	public QADResponse createTeam(@RequestBody TeamVo team) {
		LOGGER.info("Creating team {}", team);
		return teamDelegate.createTeam(team);
	}
}
