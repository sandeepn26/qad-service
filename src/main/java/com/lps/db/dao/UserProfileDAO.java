package com.lps.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lps.db.entity.User;
import com.lps.db.entity.UserDetail;

@Repository
public interface UserProfileDAO extends JpaRepository<UserDetail, Integer> {

}