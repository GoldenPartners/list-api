package dev.jpp.listapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jpp.listapi.model.UserRoleModel;
import dev.jpp.listapi.service.UserRoleService;

@RestController
@RequestMapping("/userroles")
public class UserRoleRestController {
	@Autowired
	@Qualifier("userRoleServiceJpaImpl")
	private UserRoleService service;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("pong...", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserRoleModel>> listUserRoles() {
		List<UserRoleModel> result = service.findAll();
		return new ResponseEntity<List<UserRoleModel>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserRoleModel> getUserRole(@PathVariable("id") Long id) {
		UserRoleModel userRole = service.findById(id);
		return new ResponseEntity<UserRoleModel>(userRole, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> createUserRole(@RequestBody UserRoleModel userRole) {
		userRole = service.add(userRole);
		
		if (userRole != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateUserRole(@RequestBody UserRoleModel userRole) {
		service.update(userRole);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserRole(@PathVariable("id") Long id) {
		service.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
