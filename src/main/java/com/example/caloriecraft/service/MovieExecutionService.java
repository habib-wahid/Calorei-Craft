package com.example.caloriecraft.service;

import com.example.caloriecraft.domain.MoviesTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieExecutionService {

    List<MoviesTemplate> movieList = new ArrayList<>();

    public List<MoviesTemplate> listOfMovies() {
        MoviesTemplate movie1 = new MoviesTemplate("1", "The Shawshank Redemption", "Drama", "9.3",
                "1994-09-23", "142", "Frank Darabont", "Tim Robbins, Morgan Freeman, Bob Gunton",
                "Two imprisoned", "https://www.youtube.com/watch?v=6hB3S9bIaco",
                "https://www.imdb.com/title/tt0111161/", "active", "2021-08-01", "2021-08-01", null);
        MoviesTemplate movie2 = new MoviesTemplate("2", "The Godfather", "Crime", "9.2", "1972-03-24",
                "175", "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan",
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                "https://www.youtube.com/watch?v=sY1S34973zA", "https://www.imdb.com/title/tt0068646/",
                "active", "2021-08-01", "2021-08-01", null);

        movieList.add(movie1);
        movieList.add(movie2);

        return movieList;
    }

    public MoviesTemplate addMovie(MoviesTemplate movie) {
        movieList.add(movie);
        return movie;
    }


}
