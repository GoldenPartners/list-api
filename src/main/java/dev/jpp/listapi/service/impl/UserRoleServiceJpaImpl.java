package dev.jpp.listapi.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.Converter;
import dev.jpp.listapi.entity.UserRole;
import dev.jpp.listapi.model.UserRoleModel;
import dev.jpp.listapi.repository.UserRoleRepository;
import dev.jpp.listapi.service.UserRoleService;

@Service("userRoleServiceJpaImpl")
public class UserRoleServiceJpaImpl implements UserRoleService {

	@Autowired
	@Qualifier("userRoleRepository")
	private UserRoleRepository repository;
	
	private Converter<UserRole, UserRoleModel> converter = new Converter<>(UserRole.class, UserRoleModel.class);
	
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
	public void remove(Long id) {
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
	public UserRoleModel findById(Long id) {
		return converter.entityToModel(repository.findOne(id));
	}
	
	@Override
	public Set<UserRoleModel> getListForUser(Long iduser) {
		return new HashSet<>(converter.listEntityToListModel(repository.findRolesByUser(iduser)));
	}

	@Override
	public Set<UserRoleModel> addSetOfRolesForUser(Set<UserRoleModel> roles) {
		Iterator<UserRoleModel> iterator = roles.iterator();
		Set<UserRoleModel> ret = new HashSet<>();
        
        while (iterator.hasNext()) {
			ret.add(this.add(iterator.next()));
		}
        
		return ret;
	}

	@Override
	public Set<UserRoleModel> updateSetOfRolesForUser(Long iduser, Set<UserRoleModel> roles) {
		List<UserRoleModel> currentRoles = converter.listEntityToListModel(repository.findRolesByUser(iduser));
		Iterator<UserRoleModel> updRoles = roles.iterator();
		Set<UserRoleModel> rolesToAdd = new HashSet<>();
		
		while (updRoles.hasNext()) {
			UserRoleModel updRole = updRoles.next();
			boolean isnewrole = true;
			
			for (UserRoleModel currentRole : currentRoles) {
				if (updRole.getRole().equals(currentRole.getRole())) {
					isnewrole = false;
				}
			}
			
			if (isnewrole) {
				rolesToAdd.add(updRole);
			} else {
				currentRoles.remove(updRole);
			}
		}
		
		if (rolesToAdd.isEmpty() && currentRoles.isEmpty()) {
			return roles;
		}
		
		for (UserRoleModel userRoleModel : currentRoles) {
			this.remove(userRoleModel.getId());
		}
		
		for (UserRoleModel userRoleModel : rolesToAdd) {
			this.add(userRoleModel);
		}
		
		return this.getListForUser(iduser);
	}

}
