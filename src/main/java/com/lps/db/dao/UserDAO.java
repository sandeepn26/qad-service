package com.lps.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lps.db.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	User getByEmail(String email);
}