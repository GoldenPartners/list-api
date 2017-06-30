package dev.jpp.listapi.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dev.jpp.listapi.entity.EventList;
import dev.jpp.listapi.model.EventListModel;

@Component("eventListConverter")
public class EventListConverter implements IConverter<EventList, EventListModel> {

	@Autowired
	@Qualifier("eventConverter")
	private EventConverter eventConv;
	
	@Autowired
	@Qualifier("listTypeConverter")
	private ListTypeConverter ltConv;
	
	@Autowired
	@Qualifier("guestListConverter")
	private GuestListConverter glConv;
	
	@Override
	public EventList modelToEntity(EventListModel model) {
		return new EventList(model.getId(), eventConv.modelToEntity(model.getEvent()), ltConv.modelToEntity(model.getListType()), glConv.listModelToListEntity(model.getLists()));
	}

	@Override
	public List<EventList> listModelToListEntity(List<EventListModel> models) {
		List<EventList> entities = new ArrayList<>();
		
		for (EventListModel model : models) {
			entities.add(this.modelToEntity(model));
		}
		
		return entities;
	}

	@Override
	public EventListModel entityToModel(EventList entity) {
		return new EventListModel(entity.getId(), eventConv.entityToModel(entity.getEvent()), ltConv.entityToModel(entity.getListType()), glConv.listEntityToListModel(entity.getGuestLists()));
	}

	@Override
	public List<EventListModel> listEntityToListModel(List<EventList> entities) {
		List<EventListModel> models = new ArrayList<>();
		
		for (EventList entity : entities) {
			models.add(this.entityToModel(entity));
		}
		
		return models;
	}

}
