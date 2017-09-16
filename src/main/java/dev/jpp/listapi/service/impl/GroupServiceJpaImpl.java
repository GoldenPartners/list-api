package dev.jpp.listapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.Converter;
import dev.jpp.listapi.entity.Group;
import dev.jpp.listapi.model.GroupModel;
import dev.jpp.listapi.repository.GroupRepository;
import dev.jpp.listapi.service.GroupService;

@Service("groupServiceJpaImpl")
public class GroupServiceJpaImpl implements GroupService {
	
	@Autowired
	@Qualifier("groupRepository")
	private GroupRepository repository;
	
	private Converter<Group, GroupModel> converter = new Converter<>(Group.class, GroupModel.class);

	@Override
	public GroupModel add(GroupModel model) {
		Group group = repository.save(converter.modelToEntity(model));
		return converter.entityToModel(group);
	}

	@Override
	public GroupModel update(GroupModel model) {
		return add(model);
	}

	@Override
	public void remove(Long id) {
		Group group = repository.findOne(id);
		
		if (group != null) {
			repository.delete(group);
		}
	}

	@Override
	public List<GroupModel> findAll() {
		return converter.listEntityToListModel(repository.findAll());
	}

	@Override
	public GroupModel findById(Long id) {
		return converter.entityToModel(repository.findOne(id));
	}

}
