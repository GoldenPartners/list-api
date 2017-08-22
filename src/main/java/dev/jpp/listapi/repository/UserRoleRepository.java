package dev.jpp.listapi.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.jpp.listapi.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Serializable>{
	@Query("select r from UserRole r where r.user.id = ?1")
	public List<UserRole> findRolesByUser(Long idUser);
}
