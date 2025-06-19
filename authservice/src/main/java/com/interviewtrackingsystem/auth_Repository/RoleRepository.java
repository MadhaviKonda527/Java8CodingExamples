package com.interviewtrackingsystem.auth_Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interviewtrackingsystem.auth_Entity.Role;
import com.interviewtrackingsystem.auth_Entity.enums.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	
	Optional<Role> findByName(RoleName roleName);

}
