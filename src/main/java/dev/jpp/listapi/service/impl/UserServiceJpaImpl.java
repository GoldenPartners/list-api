package dev.jpp.listapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.UserConverter;
import dev.jpp.listapi.entity.User;
import dev.jpp.listapi.model.UserModel;
import dev.jpp.listapi.repository.UserRepository;
import dev.jpp.listapi.service.UserService;

@Service("userServiceJpaImpl")
public class UserServiceJpaImpl implements UserService {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository repository;
	
	@Autowired
	@Qualifier("userConverter")
	private UserConverter converter;

	@Override
	public UserModel add(UserModel userModel) {
		User user = repository.save(converter.modelToEntity(userModel));
		return converter.entityToModel(user);
	}

	@Override
	public UserModel update(UserModel userModel) {
		return add(userModel);
	}

	@Override
	public void remove(int id) {
		User user = repository.findOne(id);
		
		if (user != null) {
			repository.delete(user);
		}
	}

	@Override
	public List<UserModel> findAll() {
		return converter.listEntityToListModel(repository.findAll());
	}

	@Override
	public UserModel findById(int id) {
		return converter.entityToModel(repository.findOne(id));
	}

}
