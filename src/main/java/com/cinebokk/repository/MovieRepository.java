package com.cinebokk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinebokk.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByHeroTrue();

}