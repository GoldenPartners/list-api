package dev.jpp.listapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.ListTypeConverter;
import dev.jpp.listapi.entity.ListType;
import dev.jpp.listapi.model.ListTypeModel;
import dev.jpp.listapi.repository.ListTypeRepository;
import dev.jpp.listapi.service.ListTypeService;

@Service("listTypeServiceJpaImpl")
public class ListTypeServiceJpaImpl implements ListTypeService {

	@Autowired
	@Qualifier("listTypeRepository")
	private ListTypeRepository repository;
	
	@Autowired
	@Qualifier("listTypeConverter")
	private ListTypeConverter converter;
	
	@Override
	public ListTypeModel add(ListTypeModel model) {
		ListType listType = repository.save(converter.modelToEntity(model));
		return converter.entityToModel(listType);
	}

	@Override
	public ListTypeModel update(ListTypeModel model) {
		return add(model);
	}

	@Override
	public void remove(int id) {
		ListType listType = repository.findOne(id);
		
		if (listType != null) {
			repository.delete(listType);
		}
	}

	@Override
	public List<ListTypeModel> findAll() {
		return converter.listEntityToListModel(repository.findAll());
	}

	@Override
	public ListTypeModel findById(int id) {
		return converter.entityToModel(repository.findOne(id));
	}

}
