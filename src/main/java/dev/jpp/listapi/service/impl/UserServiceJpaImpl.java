package dev.jpp.listapi.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.jpp.listapi.converter.Converter;
import dev.jpp.listapi.entity.User;
import dev.jpp.listapi.entity.UserRole;
import dev.jpp.listapi.model.ChangePasswordModel;
import dev.jpp.listapi.model.ResetPasswordModel;
import dev.jpp.listapi.model.UserModel;
import dev.jpp.listapi.model.UserRoleModel;
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
	
	@Autowired
	private EmailManager emailManager;
	
	private Converter<User, UserModel> converter = new Converter<>(User.class, UserModel.class);
	
	@Override
	public UserModel add(UserModel userModel) {
		String password = this.makePassword(userModel.getPassword());
		
		User user = converter.modelToEntity(userModel);
		user.setPassword(passwordEncoder.encode(password));
		user = repository.save(user);
		userModel = converter.entityToModel(user);
		userModel.setRoles(userRoleService.addSetOfRolesForUser(userModel.getRoles()));
		
		emailManager.sendRegistrationEmail(userModel.getEmail(), password);
		
		return userModel; 
	}

	@Override
	public UserModel update(UserModel userModel) {
		Set<UserRoleModel> rolesToUpdate = userModel.getRoles();
		User user = converter.modelToEntity(userModel);
		user = repository.save(user);
		userModel = converter.entityToModel(user);
		userModel.setRoles(userRoleService.updateSetOfRolesForUser(user.getId(), rolesToUpdate));
		
		return userModel;
	}

	@Override
	public void remove(Long id) {
		User user = repository.findOne(id);
		
		if (user != null) {
			Iterator<UserRole> it = user.getRoles().iterator();
			while (it.hasNext()) {
				userRoleService.remove(it.next().getId());
			}
			
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
	
	private String makePassword(String password) {
		if (password != null) {
			return password;
		}
		
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		
		while (builder.length() < 10) {
			builder.append(chars.charAt(random.nextInt(chars.length())));
		}
		
		return builder.toString();
	}

	@Override
	public void resetPassword(ResetPasswordModel model) {
		User user = repository.findByEmail(model.getEmailToResetPassword());
		String newPassword = this.makePassword(null);
		user.setPassword(passwordEncoder.encode(newPassword));
		repository.save(user);
		emailManager.sendResetPasswordEmail(user.getEmail(), newPassword);
	}
	
	@Autowired
    private AuthenticationManager authManager;

	@Override
	public Boolean changePassword(ChangePasswordModel model) {
		if (!model.getNewPassword().equals(model.getRepeatPassword())) {
			return false;
		}
		
		User user = repository.findOne(model.getIduser());
		Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), model.getCurrentPassword());
		try {
			auth = authManager.authenticate(auth);			
		} catch (AuthenticationException e) {
			return false;
		}
		
		user.setPassword(passwordEncoder.encode(model.getNewPassword()));
		repository.save(user);
		
		return true;
	}
}
