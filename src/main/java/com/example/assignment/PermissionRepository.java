package com.example.assignment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {

    Optional<Permission> findByToken(String token);
}
