package com.cinebokk.service;

import java.util.List;

import com.cinebokk.entity.Theater;

public interface TheaterService {

	Theater create(Theater theater);

	List<Theater> getAll();

	List<Theater> getByMovie(Long movieId);

	Theater update(Long id, Theater theater);

	void delete(Long id);

}