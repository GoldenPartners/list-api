package dev.jpp.listapi.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dev.jpp.listapi.entity.User;
import dev.jpp.listapi.model.UserModel;

@Component("userConverter")
public class UserConverter implements IConverter<User, UserModel> {

	@Autowired
	@Qualifier("userRoleConverter")
	private UserRoleConverter userRoleConv;
	
	@Override
	public User modelToEntity(UserModel model) {
		return new User(model.getId(), model.getName(), model.getPhone(), model.getEmail(), model.getPassword(), userRoleConv.setModelToSetEntity(model.getRoles()), model.getEnabled());
	}

	@Override
	public List<User> listModelToListEntity(List<UserModel> models) {
		List<User> entities = new ArrayList<>();
		
		for (UserModel model : models) {
			entities.add(this.modelToEntity(model));
		}
		
		return entities;
	}

	@Override
	public UserModel entityToModel(User entity) {
		return new UserModel(entity.getId(), entity.getName(), entity.getPhone(), entity.getEmail(), entity.getPassword(), userRoleConv.setEntityToSetModel(entity.getRoles()), entity.getEnabled());
	}

	@Override
	public List<UserModel> listEntityToListModel(List<User> entities) {
		List<UserModel> models = new ArrayList<>();
		
		for (User entity : entities) {
			models.add(this.entityToModel(entity));
		}
		
		return models;
	}

}
