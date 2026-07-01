package com.cinebokk.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cinebokk.entity.Offer;
import com.cinebokk.service.OfferService;

@RestController
@RequestMapping("/api/offers")
@CrossOrigin("*")

public class OfferController {

	private final OfferService service;

	public OfferController(OfferService service) {

		this.service = service;

	}

	@PostMapping
	public Offer create(

			@RequestBody Offer offer

	) {

		return service.create(offer);

	}

	@GetMapping
	public List<Offer> getAll() {

		return service.getAll();

	}

	@PutMapping("/{id}")

	public Offer update(

			@PathVariable Long id,

			@RequestBody Offer offer

	) {

		return service.update(id, offer);

	}

	@DeleteMapping("/{id}")

	public void delete(

			@PathVariable Long id

	) {

		service.delete(id);

	}

}