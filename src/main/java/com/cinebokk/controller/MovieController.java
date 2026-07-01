package com.cinebokk.controller;



import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.cinebokk.DTO.MovieRequest;
import com.cinebokk.entity.Movie;
import com.cinebokk.service.MovieService;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin("*")

public class MovieController {

    private final MovieService service;

    // CONSTRUCTOR

    public MovieController(
            MovieService service
    ) {
        this.service = service;
    }

    // CREATE

    @PostMapping

    public Movie create(

            @RequestBody
            MovieRequest request

    ) {

        return service.create(
                request
        );

    }

    // GET ALL MOVIES

    @GetMapping

    public List<Movie> getAll() {

        return service.getAll();

    }

    // HERO SLIDER

    @GetMapping("/hero")

    public List<Movie> hero() {

        return service.getHeroMovies();

    }

    // UPDATE

    @PutMapping("/{id}")

    public Movie update(

            @PathVariable
            Long id,

            @RequestBody
            MovieRequest request

    ) {

        return service.update(
                id,
                request
        );

    }

    // DELETE

    @DeleteMapping("/{id}")

    public void delete(

            @PathVariable
            Long id

    ) {

        service.delete(
                id
        );

    }

}