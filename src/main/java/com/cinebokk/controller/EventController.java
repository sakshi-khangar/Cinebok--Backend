package com.cinebokk.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cinebokk.entity.Event;

import com.cinebokk.service.EventService;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")

public class EventController {

	private final EventService service;

	public EventController(EventService service) {

		this.service = service;

	}

	@PostMapping
	public Event create(@RequestBody Event event) {

		return service.create(event);

	}

	@GetMapping
	public List<Event> getAll() {

		return service.getAll();

	}

	@PutMapping("/{id}")

	public Event update(

			@PathVariable Long id,

			@RequestBody Event event

	) {

		return service.update(id, event);

	}

	@DeleteMapping("/{id}")

	public void delete(

			@PathVariable Long id

	) {

		service.delete(id);

	}

}