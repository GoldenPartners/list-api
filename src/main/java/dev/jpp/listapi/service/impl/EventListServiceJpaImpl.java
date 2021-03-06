package dev.jpp.listapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.Converter;
import dev.jpp.listapi.entity.EventList;
import dev.jpp.listapi.model.EventListModel;
import dev.jpp.listapi.repository.EventListRepository;
import dev.jpp.listapi.service.EventListService;

@Service("eventListServiceJpaImpl")
public class EventListServiceJpaImpl implements EventListService {

	@Autowired
	@Qualifier("eventListRepository")
	private EventListRepository repository;
	
	private Converter<EventList, EventListModel> converter = new Converter<>(EventList.class, EventListModel.class);
	
	@Override
	public EventListModel add(EventListModel model) {
		EventList eventList = repository.save(converter.modelToEntity(model));
		return converter.entityToModel(eventList);
	}

	@Override
	public EventListModel update(EventListModel model) {
		return add(model);
	}

	@Override
	public void remove(Long id) {
		EventList eventList = repository.findOne(id);
		
		if (eventList != null) {
			repository.delete(eventList);
		}
	}

	@Override
	public List<EventListModel> findAll() {
		return converter.listEntityToListModel(repository.findAll());
	}

	@Override
	public EventListModel findById(Long id) {
		return converter.entityToModel(repository.findOne(id));
	}

}
