package com.globallink.ctm.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallink.ctm.db.entity.User;
import com.globallink.ctm.db.entity.UserDetail;

@Repository
public interface UserProfileDAO extends JpaRepository<UserDetail, Integer> {

}