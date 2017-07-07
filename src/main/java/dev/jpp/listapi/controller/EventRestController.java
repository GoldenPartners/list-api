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

import dev.jpp.listapi.model.EventModel;
import dev.jpp.listapi.service.EventService;

@RestController
@RequestMapping("/events")
public class EventRestController {
	@Autowired
	@Qualifier("eventServiceJpaImpl")
	private EventService service;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("pong...", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EventModel>> listEvents() {
		List<EventModel> result = service.findAll();
		return new ResponseEntity<List<EventModel>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EventModel> getEvent(@PathVariable("id") Long id) {
		EventModel event = service.findById(id);
		return new ResponseEntity<EventModel>(event, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> createEvent(@RequestBody EventModel event) {
		event = service.add(event);
		
		if (event != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateEvent(@RequestBody EventModel event) {
		service.update(event);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable("id") Long id) {
		service.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
