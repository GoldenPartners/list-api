package dev.jpp.listapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jpp.listapi.entity.EventList;

@Repository("eventListRepository")
public interface EventListRepository extends JpaRepository<EventList, Serializable> {

}
