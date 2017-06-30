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

import dev.jpp.listapi.model.GuestListModel;
import dev.jpp.listapi.service.GuestListService;

@RestController
@RequestMapping("/guestlists")
public class GuestListRestController {
	@Autowired
	@Qualifier("guestListServiceJpaImpl")
	private GuestListService service;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("pong...", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<GuestListModel>> listGuestLists() {
		List<GuestListModel> result = service.findAll();
		return new ResponseEntity<List<GuestListModel>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GuestListModel> getGuestList(@PathVariable("id") int id) {
		GuestListModel guestList = service.findById(id);
		return new ResponseEntity<GuestListModel>(guestList, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> createGuestList(@RequestBody GuestListModel guestList) {
		guestList = service.add(guestList);
		
		if (guestList != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateGuestList(@RequestBody GuestListModel guestList) {
		service.update(guestList);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGuestList(@PathVariable("id") int id) {
		service.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
