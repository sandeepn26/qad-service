package com.qad.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qad.db.entity.team.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	
	public Optional<Team> findByTeamCode(String teamCode);

}
