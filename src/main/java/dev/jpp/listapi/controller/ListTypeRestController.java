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

import dev.jpp.listapi.model.ListTypeModel;
import dev.jpp.listapi.service.impl.ListTypeServiceJpaImpl;

@RestController
@RequestMapping("/listTypes")
public class ListTypeRestController {
	@Autowired
	@Qualifier("listTypeServiceJpaImpl")
	private ListTypeServiceJpaImpl service;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("pong...", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ListTypeModel>> listListTypes() {
		List<ListTypeModel> result = service.findAll();
		return new ResponseEntity<List<ListTypeModel>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ListTypeModel> getListType(@PathVariable("id") Long id) {
		ListTypeModel listType = service.findById(id);
		return new ResponseEntity<ListTypeModel>(listType, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> createListType(@RequestBody ListTypeModel listType) {
		listType = service.add(listType);
		
		if (listType != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateListType(@RequestBody ListTypeModel listType) {
		service.update(listType);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteListType(@PathVariable("id") Long id) {
		service.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
