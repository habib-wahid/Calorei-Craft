package com.example.caloriecraft.controller;

import com.example.caloriecraft.domain.MoviesTemplate;
import com.example.caloriecraft.service.MovieExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
