package dev.jpp.listapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.EventConverter;
import dev.jpp.listapi.entity.Event;
import dev.jpp.listapi.model.EventModel;
import dev.jpp.listapi.repository.EventRepository;
import dev.jpp.listapi.service.EventService;

@Service("eventServiceJpaImpl")
public class EventServiceJpaImpl implements EventService {

	@Autowired
	@Qualifier("eventRepository")
	private EventRepository repository;
	
	@Autowired
	@Qualifier("eventConverter")
	private EventConverter converter;
	
	@Override
	public EventModel add(EventModel eventModel) {
		Event event = repository.save(converter.modelToEntity(eventModel));
		return converter.entityToModel(event);
	}

	@Override
	public EventModel update(EventModel eventModel) {
		return add(eventModel);
	}

	@Override
	public void remove(int id) {
		Event event = repository.findOne(id);
		
		if (event != null) {
			repository.delete(event);
		}
	}

	@Override
	public List<EventModel> findAll() {
		return converter.listEntityToListModel(repository.findAll());	
	}

	@Override
	public EventModel findById(int id) {
		return converter.entityToModel(repository.findOne(id));
	}

}
