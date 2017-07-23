package dev.jpp.listapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class EventListModel {
	private Long id;
	@JsonBackReference
	private EventModel event;
	private String description;
	@JsonManagedReference
	private List<GuestListModel> lists;
	
	public EventListModel() {
		super();
	}

	public EventListModel(Long id, EventModel event, String description, List<GuestListModel> lists) {
		super();
		this.id = id;
		this.event = event;
		this.description = description;
		this.lists = lists;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EventModel getEvent() {
		return event;
	}

	public void setEvent(EventModel event) {
		this.event = event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<GuestListModel> getLists() {
		return lists;
	}

	public void setLists(List<GuestListModel> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "EventListModel [id=" + id + ", event=" + event + ", desc=" + description + ", lists=" + lists + "]";
	}
}
