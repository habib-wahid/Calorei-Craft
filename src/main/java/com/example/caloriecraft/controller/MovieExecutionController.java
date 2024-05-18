package com.example.caloriecraft.controller;

import com.example.caloriecraft.domain.MoviesTemplate;
import com.example.caloriecraft.service.MovieExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/m/execution")
public class MovieExecutionController {

    private final MovieExecutionService movieExecutionService;

    @Autowired
    public MovieExecutionController(MovieExecutionService movieExecutionService) {
        this.movieExecutionService = movieExecutionService;
    }

    @GetMapping("/movies")
    public List<MoviesTemplate> getMovies() {
        return movieExecutionService.listOfMovies();
    }

    @PostMapping("/save-movie")
    public ResponseEntity<?> addMovies(@RequestBody MoviesTemplate movie) {
        return movieExecutionService.addMovie(movie);
    }
}
