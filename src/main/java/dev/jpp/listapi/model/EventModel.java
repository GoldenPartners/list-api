package dev.jpp.listapi.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class EventModel {
	private Long id;
	private String name;
	private String description;
	private Date date;
	private UserModel creator;
	private String state;
	
	@JsonManagedReference
	private List<EventListModel> lists;
	
	public EventModel() {
		super();
	}

	public EventModel(Long id, String name, String description, Date date, UserModel creator, String state, List<EventListModel> lists) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
		this.creator = creator;
		this.state = state;
		this.lists = lists;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public UserModel getCreator() {
		return creator;
	}

	public void setCreator(UserModel creator) {
		this.creator = creator;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<EventListModel> getLists() {
		return lists;
	}

	public void setLists(List<EventListModel> lists) {
		this.lists = lists;
	}

	@Override
	public String toString() {
		return "EventModel [id=" + id + ", name=" + name + ", description=" + description + ", date=" + date
				+ ", lists=" + lists + "]";
	}
}
