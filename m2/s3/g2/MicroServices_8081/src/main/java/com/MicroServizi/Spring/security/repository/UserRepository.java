package com.MicroServizi.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MicroServizi.Spring.security.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    User findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
