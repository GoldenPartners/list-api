package dev.jpp.listapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jpp.listapi.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {
	public abstract User findByEmail(String email);
}
