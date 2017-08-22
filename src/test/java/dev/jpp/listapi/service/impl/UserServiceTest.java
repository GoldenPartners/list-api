package dev.jpp.listapi.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import dev.jpp.listapi.entity.Role;
import dev.jpp.listapi.model.UserModel;
import dev.jpp.listapi.model.UserRoleModel;


public class UserServiceTest {
	
//	@Autowired
//	@Qualifier("userServiceJpaImpl")
//	private UserServiceJpaImpl service;

	@Test
	public void addUserTest() {
//		Set<UserRoleModel> roles = new HashSet<>();
//		roles.add(new UserRoleModel(null, null, Role.RRPP.getRoleName()));
//		UserModel model1 = new UserModel(null, "Publica Uno", "123124123", "publica.uno@gmail.com", null, roles, true);
//		
//		roles.add(new UserRoleModel(null, null, Role.BOSS.getRoleName()));
//		UserModel model2 = new UserModel(null, "Publica Dos", "123124123", "publica.dos@gmail.com", null, roles, true);
//		
//		model2 = service.add(model2);
//		model1.setBoss(model2);
//		model1 = service.add(model1);
//		
//		System.out.println("Fin test!");
	}
}
