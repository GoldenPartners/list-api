package dev.jpp.listapi.service;

import java.util.Set;

import dev.jpp.listapi.model.UserRoleModel;

public interface UserRoleService extends ISimpleCrudService<UserRoleModel> {
	public abstract Set<UserRoleModel> getListForUser(Long iduser);
	public abstract Set<UserRoleModel> addSetOfRolesForUser(Set<UserRoleModel> roles);
	public abstract Set<UserRoleModel> updateSetOfRolesForUser(Long iduser, Set<UserRoleModel> roles);
}
