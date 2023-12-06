package com.workintech.springmovie.service;

import com.workintech.springmovie.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(int id);
    Movie save(Movie movie);
    Movie delete(int id);
}
