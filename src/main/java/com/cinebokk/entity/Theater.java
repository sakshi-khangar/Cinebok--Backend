package com.cinebokk.entity;


import java.util.List;

import jakarta.persistence.*;

@Entity
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String name;

	private String city;

	@ElementCollection
	private List<String> timings;

	@ManyToOne
	@JoinColumn(name="movie_id")

	private Movie movie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getTimings() {
		return timings;
	}

	public void setTimings(List<String> timings) {
		this.timings = timings;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}