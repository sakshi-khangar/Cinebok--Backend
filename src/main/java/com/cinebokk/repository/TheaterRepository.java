package com.cinebokk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinebokk.entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

	List<Theater> findByMovieId(Long movieId);

}