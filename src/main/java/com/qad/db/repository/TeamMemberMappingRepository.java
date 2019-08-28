package com.qad.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qad.db.entity.team.TeamMemberMapping;

@Repository
public interface TeamMemberMappingRepository extends JpaRepository<TeamMemberMapping, Long> {
	
	public Optional<TeamMemberMapping> findByMemberCodeAndTeamCode(String memberCode, String teamCode);

}
