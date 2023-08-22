package com.MicroServizi.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MicroServizi.Spring.security.entity.ERole;
import com.MicroServizi.Spring.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
