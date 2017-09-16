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

import dev.jpp.listapi.model.GroupModel;
import dev.jpp.listapi.service.GroupService;

@RestController
@RequestMapping("/groups")
public class GroupRestController {
	@Autowired
	@Qualifier("groupServiceJpaImpl")
	private GroupService service;
	
	@GetMapping("/")
	public ResponseEntity<List<GroupModel>> listGroups() {
		List<GroupModel> result = service.findAll();
		return new ResponseEntity<List<GroupModel>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GroupModel> getGroup(@PathVariable("id") Long id) {
		GroupModel result = service.findById(id);
		return new ResponseEntity<GroupModel>(result, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> createGroup(@RequestBody GroupModel group) {
		group = service.add(group);
		
		if (group != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateGroup(@RequestBody GroupModel group) {
		service.update(group);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGroup(@PathVariable("id") Long id) {
		service.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
