package dev.jpp.listapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jpp.listapi.entity.GroupUser;

@Repository("groupUserRepository")
public interface GroupUserRepository extends JpaRepository<GroupUser, Serializable> {

}
