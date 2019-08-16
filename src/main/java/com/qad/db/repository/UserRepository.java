package com.qad.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qad.db.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User getByEmail(String email);
}