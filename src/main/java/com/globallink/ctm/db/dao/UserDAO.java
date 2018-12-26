package com.globallink.ctm.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallink.ctm.db.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	User getByEmail(String email);
}