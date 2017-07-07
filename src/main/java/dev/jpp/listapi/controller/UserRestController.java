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

import dev.jpp.listapi.model.UserModel;
import dev.jpp.listapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	@Qualifier("userServiceJpaImpl")
	private UserService service;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("pong...", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserModel>> listUsers() {
		List<UserModel> result = service.findAll();
		return new ResponseEntity<List<UserModel>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getUser(@PathVariable("id") Long id) {
		UserModel user = service.findById(id);
		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> createUser(@RequestBody UserModel user) {
		user = service.add(user);
		
		if (user != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateUser(@RequestBody UserModel user) {
		service.update(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		service.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
