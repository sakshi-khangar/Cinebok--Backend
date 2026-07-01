package com.cinebokk.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cinebokk.entity.Theater;
import com.cinebokk.service.TheaterService;

@RestController
@RequestMapping("/api/theaters")
@CrossOrigin("*")

public class TheaterController {

	private final TheaterService service;

	public TheaterController(TheaterService service) {

		this.service = service;

	}

	@PostMapping
	public Theater create(@RequestBody Theater theater) {

		return service.create(theater);

	}

	@GetMapping
	public List<Theater> getAll() {

		return service.getAll();

	}

	@GetMapping("/movie/{id}")

	public List<Theater> getMovie(

			@PathVariable Long id

	) {

		return service.getByMovie(id);

	}

	@PutMapping("/{id}")

	public Theater update(

			@PathVariable Long id,

			@RequestBody Theater theater

	) {

		return service.update(id, theater);

	}

	@DeleteMapping("/{id}")

	public void delete(

			@PathVariable Long id

	) {

		service.delete(id);

	}

}