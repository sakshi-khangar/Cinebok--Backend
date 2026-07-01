package com.cinebokk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinebokk.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

	List<Booking> findByTheaterIdAndShowTime(Long theaterId, String showTime);

}