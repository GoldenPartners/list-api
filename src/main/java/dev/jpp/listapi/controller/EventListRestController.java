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

import dev.jpp.listapi.model.EventListModel;
import dev.jpp.listapi.service.EventListService;

@RestController
@RequestMapping("/eventLists")
public class EventListRestController {
	@Autowired
	@Qualifier("eventListServiceJpaImpl")
	private EventListService service;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return new ResponseEntity<String>("pong...", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EventListModel>> listEventLists() {
		List<EventListModel> result = service.findAll();
		return new ResponseEntity<List<EventListModel>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EventListModel> getEventList(@PathVariable("id") int id) {
		EventListModel eventList = service.findById(id);
		return new ResponseEntity<EventListModel>(eventList, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Void> createEventList(@RequestBody EventListModel eventList) {
		eventList = service.add(eventList);
		
		if (eventList != null) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<Void> updateEventList(@RequestBody EventListModel eventList) {
		service.update(eventList);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEventList(@PathVariable("id") int id) {
		service.remove(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
