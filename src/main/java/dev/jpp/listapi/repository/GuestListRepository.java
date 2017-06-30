package dev.jpp.listapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jpp.listapi.entity.GuestList;

public interface GuestListRepository extends JpaRepository<GuestList, Serializable> {

}
