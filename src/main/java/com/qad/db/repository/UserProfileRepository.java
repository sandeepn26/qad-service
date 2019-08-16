package com.qad.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qad.db.entity.UserDetail;

@Repository
public interface UserProfileRepository extends JpaRepository<UserDetail, Long> {

}