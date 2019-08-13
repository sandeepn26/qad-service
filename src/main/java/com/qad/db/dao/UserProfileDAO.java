package com.qad.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qad.db.entity.User;
import com.qad.db.entity.UserDetail;

@Repository
public interface UserProfileDAO extends JpaRepository<UserDetail, Integer> {

}