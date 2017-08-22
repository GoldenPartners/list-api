package dev.jpp.listapi.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import dev.jpp.listapi.model.UserRoleModel;

public class UpdateRolesTest {

	private static List<UserRoleModel> currentRoles;
	private static Set<UserRoleModel> updateRoles;
	
	@BeforeClass
	public static void initTest() {
		currentRoles = new ArrayList<>();
		updateRoles = new HashSet<>();
		
		UserRoleModel admin = new UserRoleModel(null, null, "admin");
		UserRoleModel boss = new UserRoleModel(null, null, "boss");
		UserRoleModel rrpp = new UserRoleModel(null, null, "rrpp");
		UserRoleModel recpt = new UserRoleModel(null, null, "receptionist");
		
		currentRoles.add(admin);
		currentRoles.add(boss);
		currentRoles.add(recpt);
		
		updateRoles.add(admin);
		updateRoles.add(recpt);
		updateRoles.add(boss);
	}
	
	@Test
	public void updateRolesForUserTest() {
		List<UserRoleModel> newRoles = new ArrayList<>();
		Iterator<UserRoleModel> updRoles = updateRoles.iterator();
		
		while (updRoles.hasNext()) {
			UserRoleModel updRole = updRoles.next();
			boolean isnewrole = true;
			
			for (UserRoleModel currentRole : currentRoles) {
				if (updRole.getRole().equals(currentRole.getRole())) {
					isnewrole = false;
				}
			}
			
			if (isnewrole) {
				newRoles.add(updRole);
			} else {
				currentRoles.remove(updRole);
			}
		}
		
		System.out.println("roles to add " + newRoles.size());
		System.out.println("roles to remove " + currentRoles.size());
		//newRoles -> add to DB
		//currentRoles -> remove from DB
	}
}
