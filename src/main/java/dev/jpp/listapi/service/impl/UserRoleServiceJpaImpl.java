package dev.jpp.listapi.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	public Set<UserRoleModel> addSetOfRolesForUser(Set<UserRoleModel> roles) {
		Iterator<UserRoleModel> iterator = roles.iterator();
		Set<UserRoleModel> ret = new HashSet<>();
        
        while (iterator.hasNext()) {
			ret.add(this.add(iterator.next()));
		}
        
		return ret;
	}

}
