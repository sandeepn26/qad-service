package com.qad.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qad.db.entity.auth.JwtToken;

@Repository
public interface TokenRepository extends JpaRepository<JwtToken, Long> {

	Optional<JwtToken> findByUsername(String username);
	
	Optional<JwtToken> findByToken(String token);
}
