package dev.jpp.listapi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lst_eventlist")
public class EventList {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="event_id", nullable=false)
	private Event event;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="eventList")
	private List<GuestList> guestLists;

	public EventList() {
		super();
	}

	public EventList(Long id, Event event, String description, List<GuestList> guestLists) {
		super();
		this.id = id;
		this.event = event;
		this.description = description;
		this.guestLists = guestLists;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<GuestList> getGuestLists() {
		return guestLists;
	}

	public void setGuestLists(List<GuestList> guestLists) {
		this.guestLists = guestLists;
	}

	@Override
	public String toString() {
		return "EventList [id=" + id + ", event=" + event + ", desc=" + description + ", lists=" + guestLists + "]";
	}
}
