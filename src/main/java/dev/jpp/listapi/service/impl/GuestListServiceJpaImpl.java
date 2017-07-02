package dev.jpp.listapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.Converter;
import dev.jpp.listapi.entity.GuestList;
import dev.jpp.listapi.model.GuestListModel;
import dev.jpp.listapi.repository.GuestListRepository;
import dev.jpp.listapi.service.GuestListService;

@Service("guestListServiceJpaImpl")
public class GuestListServiceJpaImpl implements GuestListService {

	@Autowired
	@Qualifier("guestListRepository")
	private GuestListRepository repository;
	
//	@Autowired
//	@Qualifier("guestListConverter")
//	private GuestListConverter converter;
	
	private Converter<GuestList, GuestListModel> converter = new Converter<>(GuestList.class, GuestListModel.class);
	
	@Override
	public GuestListModel add(GuestListModel model) {
		GuestList guestList = repository.save(converter.modelToEntity(model));
		return converter.entityToModel(guestList);
	}

	@Override
	public GuestListModel update(GuestListModel model) {
		return add(model);
	}

	@Override
	public void remove(int id) {
		GuestList guestList = repository.findOne(id);
		
		if (guestList != null) {
			repository.delete(guestList);
		}
	}

	@Override
	public List<GuestListModel> findAll() {
		return converter.listEntityToListModel(repository.findAll());
	}

	@Override
	public GuestListModel findById(int id) {
		return converter.entityToModel(repository.findOne(id));
	}

}
