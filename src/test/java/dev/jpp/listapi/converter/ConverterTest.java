package dev.jpp.listapi.converter;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import dev.jpp.listapi.entity.User;
import dev.jpp.listapi.entity.UserRole;
import dev.jpp.listapi.model.UserModel;

public class ConverterTest {
	private static User user;
	private static UserModel userModel;
	
	@BeforeClass
	public static void InitBinder() {
		user = new User(132, "Juan Pablo Petrozzi", "12312412", "juanpablopetrozzi@gmail.com", "admin1234", null, true);
		Set<UserRole> roles = new HashSet<>();
		roles.add(new UserRole(123, user, "admin"));
		user.setRoles(roles);
		
		System.out.println(user.toString());
	}
	
	@Test
	public void modelMapperConverterTest() {
		ModelMapper mapper = new ModelMapper();
		userModel = mapper.map(user, UserModel.class);
		System.out.println(userModel);
		System.out.println(userModel.getRoles());
	}
}
