package dev.jpp.listapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jpp.listapi.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Serializable>{

}
