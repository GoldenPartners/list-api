package dev.jpp.listapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.Converter;
import dev.jpp.listapi.entity.User;
import dev.jpp.listapi.model.UserModel;
import dev.jpp.listapi.repository.UserRepository;
import dev.jpp.listapi.service.UserRoleService;
import dev.jpp.listapi.service.UserService;

@Service("userServiceJpaImpl")
public class UserServiceJpaImpl implements UserService {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository repository;
	
	@Autowired
	@Qualifier("userRoleServiceJpaImpl")
	private UserRoleService userRoleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private Converter<User, UserModel> converter = new Converter<>(User.class, UserModel.class);
	
	@Override
	public UserModel add(UserModel userModel) {
		User user = converter.modelToEntity(userModel);
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		user = repository.save(user);
		userModel = converter.entityToModel(user);
		userModel.setRoles(userRoleService.addSetOfRolesForUser(userModel.getRoles()));
		
		return userModel; 
	}

	@Override
	public UserModel update(UserModel userModel) {
		return add(userModel);
	}

	@Override
	public void remove(Long id) {
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
	public UserModel findById(Long id) {
		return converter.entityToModel(repository.findOne(id));
	}

}
