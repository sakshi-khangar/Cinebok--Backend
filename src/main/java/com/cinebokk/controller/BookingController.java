package com.cinebokk.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cinebokk.entity.Booking;
import com.cinebokk.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("*")

public class BookingController {

	private final BookingService service;

	public BookingController(BookingService service) {	

		this.service = service;

	}

	@PostMapping
	public Booking create(

			@RequestBody Booking booking

	) {

		return service.create(booking);

	}

	@GetMapping("/{theaterId}/{time}")

	public List<Booking> getSeats(

			@PathVariable Long theaterId,

			@PathVariable String time

	) {

		return service.getSeats(theaterId, time);

	}

}
