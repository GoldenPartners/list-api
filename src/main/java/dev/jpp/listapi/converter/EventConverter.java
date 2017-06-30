package dev.jpp.listapi.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dev.jpp.listapi.entity.Event;
import dev.jpp.listapi.model.EventModel;

@Component("eventConverter")
public class EventConverter implements IConverter<Event, EventModel>{
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConv;
	
	@Autowired
	@Qualifier("eventListConverter")
	private EventListConverter elConv;
	
	@Override
	public Event modelToEntity(EventModel model) {
		return new Event(model.getId(), model.getName(), model.getDescription(), model.getDate(), userConv.modelToEntity(model.getCreator()), elConv.listModelToListEntity(model.getLists()));
	}

	@Override
	public List<Event> listModelToListEntity(List<EventModel> models) {
		List<Event> entities = new ArrayList<>();
		
		for (EventModel model : models) {
			entities.add(this.modelToEntity(model));
		}
		
		return entities;
	}

	@Override
	public EventModel entityToModel(Event entity) {
		return new EventModel(entity.getId(), entity.getName(), entity.getDescription(), entity.getDate(), userConv.entityToModel(entity.getCreator()), elConv.listEntityToListModel(entity.getLists()));
	}

	@Override
	public List<EventModel> listEntityToListModel(List<Event> entities) {		
		List<EventModel> models = new ArrayList<>();
		
		for (Event entity : entities) {
			models.add(this.entityToModel(entity));
		}
		
		return models;
	}
}
