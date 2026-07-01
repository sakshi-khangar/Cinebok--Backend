package com.cinebokk.service;



import java.util.List;

import com.cinebokk.entity.Booking;

public interface BookingService {

	Booking create(Booking booking);

	List<Booking> getSeats(Long theaterId, String showTime);

}