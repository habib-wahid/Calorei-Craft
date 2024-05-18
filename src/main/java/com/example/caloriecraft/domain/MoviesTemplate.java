package com.example.caloriecraft.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviesTemplate {

    private String id;
    private String name;
    private String genre;
    private String rating;
    private String releaseDate;
    private String duration;
    private String director;
    private String cast;
    private String description;
    private String trailer;
    private String poster;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
}
