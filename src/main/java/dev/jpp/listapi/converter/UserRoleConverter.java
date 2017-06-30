package dev.jpp.listapi.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dev.jpp.listapi.entity.UserRole;
import dev.jpp.listapi.model.UserRoleModel;

@Component("userRoleConverter")
public class UserRoleConverter implements IConverter<UserRole, UserRoleModel> {

	@Autowired
	@Qualifier("userConverter")
	private UserConverter userConv;
	
	@Override
	public UserRole modelToEntity(UserRoleModel model) {
		return new UserRole(model.getId(), userConv.modelToEntity(model.getUser()), model.getRole());
	}

	@Override
	public List<UserRole> listModelToListEntity(List<UserRoleModel> models) {
		List<UserRole> entities = new ArrayList<>();
		
		for (UserRoleModel model : models) {
			entities.add(this.modelToEntity(model));
		}
		
		return entities;
	}

	@Override
	public UserRoleModel entityToModel(UserRole entity) {
		return new UserRoleModel(entity.getId(), userConv.entityToModel(entity.getUser()), entity.getRole());
	}

	@Override
	public List<UserRoleModel> listEntityToListModel(List<UserRole> entities) {
		List<UserRoleModel> models = new ArrayList<>();
		
		for (UserRole entity : entities) {
			models.add(this.entityToModel(entity));
		}
		
		return models;
	}
	
	public Set<UserRole> setModelToSetEntity(Set<UserRoleModel> models) {
		Set<UserRole> entities = new HashSet<>();
		
		for (UserRoleModel model : models) {
			entities.add(this.modelToEntity(model));
		}
		
		return entities;
	}
	
	public Set<UserRoleModel> setEntityToSetModel(Set<UserRole> entities) {
		Set<UserRoleModel> models = new HashSet<>();
		
		for (UserRole entity : entities) {
			models.add(this.entityToModel(entity));
		}
		
		return models;
	}

}
