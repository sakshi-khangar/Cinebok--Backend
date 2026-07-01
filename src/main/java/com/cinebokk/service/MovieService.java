package com.cinebokk.service;

import java.util.List;

import com.cinebokk.DTO.MovieRequest;
import com.cinebokk.entity.Movie;

public interface MovieService {

	Movie create(MovieRequest request);

	List<Movie> getAll();

	List<Movie> getHeroMovies();

	Movie update(Long id, MovieRequest request);

	void delete(Long id);

}