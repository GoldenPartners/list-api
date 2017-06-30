package dev.jpp.listapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jpp.listapi.entity.ListType;


@Repository("listTypeRepository")
public interface ListTypeRepository extends JpaRepository<ListType, Serializable> {

}
