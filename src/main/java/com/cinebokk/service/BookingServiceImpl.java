package com.cinebokk.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.cinebokk.entity.Booking;
import com.cinebokk.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	private final BookingRepository repository;

	public BookingServiceImpl(BookingRepository repository) {

		this.repository = repository;

	}

	@Override
	public Booking create(Booking booking) {

		return repository.save(booking);

	}

	@Override
	public List<Booking> getSeats(

			Long theaterId,

			String showTime

	) {

		return repository.findByTheaterIdAndShowTime(theaterId, showTime);

	}

}