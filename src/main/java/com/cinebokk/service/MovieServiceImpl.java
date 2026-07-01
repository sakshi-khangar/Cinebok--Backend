package com.cinebokk.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cinebokk.DTO.MovieRequest;
import com.cinebokk.entity.Movie;
import com.cinebokk.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository repository;

	public MovieServiceImpl(MovieRepository repository) {
		this.repository = repository;
	}

	@Override
	public Movie create(MovieRequest request) {

		Movie movie = new Movie();

		movie.setTitle(request.getTitle());
		movie.setDescription(request.getDescription());
		movie.setGenre(request.getGenre());
		movie.setLanguage(request.getLanguage());
		movie.setPoster(request.getPoster());
		movie.setTrailer(request.getTrailer());
		movie.setCity(request.getCity());
		movie.setRating(request.getRating());
		movie.setReleaseDate(request.getReleaseDate());

		// IMPORTANT
		movie.setHero(Boolean.TRUE.equals(request.isHero()));

		return repository.save(movie);
	}

	@Override
	public List<Movie> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Movie> getHeroMovies() {

		return repository.findByHeroTrue();

	}

	@Override
	public Movie update(Long id, MovieRequest request) {

		Movie movie =
				repository
				.findById(id)
				.orElseThrow();

		movie.setTitle(request.getTitle());
		movie.setDescription(request.getDescription());
		movie.setGenre(request.getGenre());
		movie.setLanguage(request.getLanguage());
		movie.setPoster(request.getPoster());
		movie.setTrailer(request.getTrailer());
		movie.setCity(request.getCity());
		movie.setRating(request.getRating());
		movie.setReleaseDate(request.getReleaseDate());

		// IMPORTANT
		movie.setHero(Boolean.TRUE.equals(request.isHero()));

		return repository.save(movie);
	}

	@Override
	public void delete(Long id) {

		repository.deleteById(id);

	}
}