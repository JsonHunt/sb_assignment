package com.example.assignment.dao;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.example.assignment.entity.Permission;

public interface PermissionRepository extends Repository<Permission,Long> {

    Optional<Permission> findByToken(String token);
}
