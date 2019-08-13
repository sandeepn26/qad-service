package com.qad.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qad.db.entity.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, String> {

}
