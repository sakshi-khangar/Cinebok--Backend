package com.cinebokk.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.cinebokk.entity.Movie;
import com.cinebokk.entity.Theater;
import com.cinebokk.repository.MovieRepository;
import com.cinebokk.repository.TheaterRepository;

@Service
public class TheaterServiceImpl implements TheaterService {

	private final TheaterRepository repository;

	private final MovieRepository movieRepo;

	public TheaterServiceImpl(TheaterRepository repository, MovieRepository movieRepo) {

		this.repository = repository;

		this.movieRepo = movieRepo;

	}

	@Override
	public Theater create(Theater theater) {

		Movie movie = movieRepo.findById(theater.getMovie().getId()).orElseThrow();

		theater.setMovie(movie);

		return repository.save(theater);

	}

	@Override
	public List<Theater> getAll() {

		return repository.findAll();

	}

	@Override
	public List<Theater> getByMovie(Long movieId) {

		return repository.findByMovieId(movieId);

	}

	@Override
	public Theater update(Long id, Theater theater) {

		Theater old = repository.findById(id).orElseThrow();

		old.setName(theater.getName());

		old.setCity(theater.getCity());

		old.setTimings(theater.getTimings());

		old.setMovie(theater.getMovie());

		return repository.save(old);

	}

	@Override
	public void delete(Long id) {

		repository.deleteById(id);

	}

}