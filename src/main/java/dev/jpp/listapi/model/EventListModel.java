package dev.jpp.listapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class EventListModel {
	private Long id;
	@JsonBackReference
	private EventModel event;
	private ListTypeModel listType;
	@JsonManagedReference
	private List<GuestListModel> lists;
	
	public EventListModel() {
		super();
	}

	public EventListModel(Long id, EventModel event, ListTypeModel listType, List<GuestListModel> lists) {
		super();
		this.id = id;
		this.event = event;
		this.listType = listType;
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

	public ListTypeModel getListType() {
		return listType;
	}

	public void setListType(ListTypeModel listType) {
		this.listType = listType;
	}

	public List<GuestListModel> getLists() {
		return lists;
	}

	public void setLists(List<GuestListModel> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "EventListModel [id=" + id + ", event=" + event + ", listType=" + listType + ", lists=" + lists + "]";
	}
}
