package dev.jpp.listapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.UserRoleConverter;
import dev.jpp.listapi.entity.UserRole;
import dev.jpp.listapi.model.UserRoleModel;
import dev.jpp.listapi.repository.UserRoleRepository;
import dev.jpp.listapi.service.UserRoleService;

@Service("userRoleServiceJpaImpl")
public class UserRoleServiceJpaImpl implements UserRoleService {

	@Autowired
	@Qualifier("userRoleRepository")
	private UserRoleRepository repository;
	
	@Autowired
	@Qualifier("userRoleConverter")
	private UserRoleConverter converter;
	
	@Override
	public UserRoleModel add(UserRoleModel model) {
		UserRole userRole = repository.save(converter.modelToEntity(model));
		return converter.entityToModel(userRole);
	}

	@Override
	public UserRoleModel update(UserRoleModel model) {
		return add(model);
	}

	@Override
	public void remove(int id) {
		UserRole userRole = repository.findOne(id);
		
		if (userRole != null) {
			repository.delete(userRole);
		}
	}

	@Override
	public List<UserRoleModel> findAll() {
		return converter.listEntityToListModel(repository.findAll());
	}

	@Override
	public UserRoleModel findById(int id) {
		return converter.entityToModel(repository.findOne(id));
	}

}
