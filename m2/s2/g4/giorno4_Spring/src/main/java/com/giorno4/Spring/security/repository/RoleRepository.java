package com.giorno4.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giorno4.Spring.security.entity.ERole;
import com.giorno4.Spring.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
