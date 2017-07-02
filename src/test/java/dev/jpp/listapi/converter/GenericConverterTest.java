package dev.jpp.listapi.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import dev.jpp.listapi.entity.User;
import dev.jpp.listapi.entity.UserRole;
import dev.jpp.listapi.model.UserModel;

public class GenericConverterTest {
	private static Converter<User, UserModel> converter = new Converter<>(User.class, UserModel.class);
	
	private static User user;
	private static UserModel userModel;
	
	@BeforeClass
	public static void init() {
		user = new User(132, "Juan Pablo Petrozzi", "12312412", "juanpablopetrozzi@gmail.com", "admin1234", null, true);
		Set<UserRole> roles = new HashSet<>();
		roles.add(new UserRole(123, user, "admin"));
		user.setRoles(roles);
		
		System.out.println(user.toString());
	}
	
	@Test
	public void entityToModelTest() {
		userModel = converter.entityToModel(user);
		System.out.println(userModel);
		System.out.println(userModel.getRoles());
	}
	
	@Test
	public void modelToEntityTest() {
		entityToModelTest();
		
		user = null;
		user = converter.modelToEntity(userModel);
		System.out.println(user);
		System.out.println(user.getRoles());
	}
	
	@Test
	public void listEntitiesToListModelsTest() {
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user);
		users.add(user);
		users.add(user);
		users.add(user);
		users.add(user);
		
		List<UserModel> models = converter.listEntityToListModel(users);
		System.out.println(models);
	}
	
	@Test
	public void listModelsToListEntities() {
		entityToModelTest();
		
		List<UserModel> models = new ArrayList<>();
		models.add(userModel);
		models.add(userModel);
		models.add(userModel);
		models.add(userModel);
		models.add(userModel);
		models.add(userModel);
		models.add(userModel);
		models.add(userModel);
		
		List<User> users = converter.listModelToListEntity(models);
		System.out.println(users);
	}
}
