package com.qad.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qad.db.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
