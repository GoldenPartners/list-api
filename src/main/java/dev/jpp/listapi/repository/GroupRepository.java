package dev.jpp.listapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jpp.listapi.entity.Group;

@Repository("groupRepository")
public interface GroupRepository extends JpaRepository<Group, Serializable> {

}
