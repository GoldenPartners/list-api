package dev.jpp.listapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class GuestListModel {
	private Long id;
	private String represent;
	private UserModel creator;
	@JsonBackReference
	private EventListModel eventList;
	private int numberOfGuests;
	private String guestsNames;
	private int presents;
	
	public GuestListModel() {
		super();
	}
	
	public GuestListModel(Long id, String represent, UserModel creator, EventListModel eventList, int numberOfGuests, String guestsNames, int presents) {
		super();
		this.id = id;
		this.represent = represent;
		this.creator = creator;
		this.eventList = eventList;
		this.numberOfGuests = numberOfGuests;
		this.guestsNames = guestsNames;
		this.presents = presents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRepresent() {
		return represent;
	}

	public void setRepresent(String represent) {
		this.represent = represent;
	}

	public UserModel getCreator() {
		return creator;
	}

	public void setCreator(UserModel creator) {
		this.creator = creator;
	}

	public EventListModel getEventList() {
		return eventList;
	}

	public void setEventList(EventListModel eventList) {
		this.eventList = eventList;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public String getGuestsNames() {
		return guestsNames;
	}

	public void setGuestsNames(String guestsNames) {
		this.guestsNames = guestsNames;
	}

	public int getPresents() {
		return presents;
	}

	public void setPresents(int presents) {
		this.presents = presents;
	}

	@Override
	public String toString() {
		return "GuestListModel [id=" + id + ", represent=" + represent + ", creator=" + creator + ", event=" + eventList
				+ ", numberOfGuests=" + numberOfGuests + ", guestsNames=" + guestsNames + ", presents=" + presents
				+ "]";
	}
}
