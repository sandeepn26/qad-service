package com.globallink.ctm.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globallink.ctm.db.entity.Role;

@Repository
public interface RoleDAO extends JpaRepository<Role, String> {

}
